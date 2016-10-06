package org.capnproto.compiler

import scala.collection.JavaConversions._

import treehugger.forest._
import definitions._
import treehuggerDSL._

import org.capnproto.schema.CapnpSchema._

object schemaPackage {
  def apply(name: String, contents: Seq[ModuleDef]): Tree = {
    val (pkgObject, pkgName) = name.lastIndexOf(".") match {
      case -1 => (name, name)
      case i => (name.substring(i+1), name.substring(0,i))
    }

    PACKAGE(pkgName) := (
      PACKAGEOBJECTDEF(pkgObject) := BLOCK(contents)
    )
  }
}

object struct {
  def reader(node: Node.Struct.Reader): Unit = {

  }

  def structReader(contents: Tree*): ClassDef = {
    val args: Seq[ValDef] = Seq(
      PARAM("segment", "org.capnproto.SegmentReader"),
      PARAM("data", IntClass),
      PARAM("pointers", IntClass),
      PARAM("dataSize", IntClass),
      PARAM("pointerCount", ShortClass),
      PARAM("nestingLimit", IntClass)
    )

    val argsRef = args.map(_.name).map(REF)

    CLASSDEF("Reader")
      .withParams(args)
      .withParents(REF("org.capnproto.StructReader") APPLY argsRef) := Block(
      contents: _*
    )
  }

  def structBuilder(reader: ClassDef, contents: Tree*): ClassDef = {
    val args: Seq[ValDef] = Seq(
      PARAM("segment", "org.capnproto.SegmentBuilder"),
      PARAM("data", IntClass),
      PARAM("pointers", IntClass),
      PARAM("dataSize", IntClass),
      PARAM("pointerCount", ShortClass)
    )

    val argsRef = args.map(_.name).map(REF)
    val nestingLimitArg = LIT(0x7ffffff)
    val asReaderMethod = DEF("asReader", TYPE_REF(reader.name)) :=
      NEW(REF(reader.name), Seq("segment", "data", "pointers", "dataSize", "pointerCount").map(REF(_)) :+ nestingLimitArg : _*)

    CLASSDEF("Builder")
      .withParams(args)
      .withParents(REF("org.capnproto.StructBuilder") APPLY argsRef) := Block(
      contents :+ asReaderMethod: _*
    )
  }

  def build(name: String, reader: Node.Struct.Reader): ModuleDef = {
    val sreader = structReader(reader.getFields.map(f => getter(f.getName.toString(), f.getSlot)): _*)
    val builder = structBuilder(
      sreader,
      reader.getFields.flatMap(f => Seq(getter(f.getName.toString(), f.getSlot), setter(f.getName.toString(), f.getSlot))): _*
    )

    val parent = TYPE_REF("org.capnproto.StructFactory") TYPE_OF("Builder", "Reader")
    val constructReaderArgs: Seq[ValDef] = Seq(
      PARAM("segment", "org.capnproto.SegmentReader"),
      PARAM("data", IntClass),
      PARAM("pointers", IntClass),
      PARAM("dataSize", IntClass),
      PARAM("pointerCount", ShortClass),
      PARAM("nestingLimit", IntClass)
    )

    val constructBuilderArgs: Seq[ValDef] = Seq(
      PARAM("segment", "org.capnproto.SegmentBuilder"),
      PARAM("data", IntClass),
      PARAM("pointers", IntClass),
      PARAM("dataSize", IntClass),
      PARAM("pointerCount", ShortClass)
    )

    val structSizeType = TYPE_REF("org.capnproto.StructSize")
    val structSizeVal = VAL("STRUCT_SIZE") := NEW(structSizeType) APPLY(LIT(reader.dataSize), LIT(reader.pointers))
    val builderArg = PARAM("builder", "Builder")

    val factory = CLASSDEF("Factory") withParents parent withFlags Flags.FINAL := BLOCK(
      DEF("constructReader", TYPE_REF(sreader.name)) withFlags Flags.OVERRIDE withParams constructReaderArgs := BLOCK(
        NEW(REF(sreader.name), constructReaderArgs.map(_.name).map(REF): _*)
      ),

      DEF("constructBuilder", TYPE_REF(builder.name)) withFlags Flags.OVERRIDE withParams constructBuilderArgs := BLOCK(
        NEW(REF(builder.name), constructBuilderArgs.map(_.name).map(REF): _*)
      ),

      DEF("structSize", structSizeType) withFlags Flags.OVERRIDE := REF("STRUCT_SIZE"),

      DEF("asReader", TYPE_REF(sreader.name)) withFlags Flags.OVERRIDE withParams builderArg := REF(builderArg.name).DOT("asReader").tree
    )

    val listFactory = VAL("listFactory", TYPE_REF("org.capnproto.StructList.Factory") TYPE_OF("Builder", "Reader")) :=
      NEW(TYPE_REF("org.capnproto.StructList.Factory") TYPE_OF("Builder", "Reader"), REF("factory"))

    val factoryVal = VAL("factory") := NEW(TYPE_REF(factory.name))

    OBJECTDEF(name) := BLOCK(
      structSizeVal,
      factoryVal,
      listFactory,
      factory,
      sreader,
      builder
    )
  }

  def getter(name: String, reader: Field.Slot.Reader): DefDef = {
    DEF(name, kind.ofType(reader.getType)) := kind.getter(reader)
  }

  def setter(name: String, reader: Field.Slot.Reader): DefDef = {
    val param = PARAM("value", kind.ofType(reader.getType))
    DEF(s"${name}_=", UnitClass) withParams param := kind.setter(reader, param)
  }
}

object kind {
  def ofType(reader: Type.Reader): Symbol = {
    reader match {
      case t if t.isInt8 || t.isUint8 => ByteClass
      case t if t.isInt16 || t.isUint16 => ShortClass
    }
  }

  def getter(reader: Field.Slot.Reader): Apply = {
    reader.getType match {
      case t if t.isInt8 || t.isUint8 => REF("_getByteField") APPLY LIT(reader.getOffset)
      case t if t.isInt16 || t.isUint16 => REF("_getShortField") APPLY LIT(reader.getOffset)
    }
  }

  def setter(slot: Field.Slot.Reader, arg: ValDef): Apply = {
    slot.getType match {
      case t if t.isInt8 || t.isUint8 => REF("_setByteField") APPLY(LIT(slot.getOffset), REF(arg.name))
      case t if t.isInt16 || t.isUint16 => REF("_setShortField") APPLY(LIT(slot.getOffset), REF(arg.name))
    }
  }
}
