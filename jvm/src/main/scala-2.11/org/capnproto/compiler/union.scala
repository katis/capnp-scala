package org.capnproto.compiler

import org.capnproto.schema.CapnpSchema

import scala.collection.JavaConversions._
import treehugger.forest._
import definitions._
import treehuggerDSL._

object union {
  def cases(name: String, group: CapnpSchema.Node.Reader): Unit = {
    assert(group.isStruct && group.getStruct.getIsGroup, "Struct must be a group")

    val className = name.capitalize

    if (group.getStruct.getFields.get(0).getSlot.getOffset != 0xffff) {

    }

    OBJECTDEF(className) := BLOCK(
      TRAITDEF("Reader") withFlags Flags.SEALED,
      TRAITDEF("Builder") withFlags Flags.SEALED
    )

    group.getStruct.getFields.get(0).getSlot.getType
    val groups = group.getStruct.getFields.filter(_.isGroup)

    val builderParams = Seq[ValDef](
      PARAM("segment", "org.capnproto.SegmentBuilder"),
      PARAM("data", IntClass),
      PARAM("pointers", IntClass),
      PARAM("dataSize", IntClass),
      PARAM("pointerCount", IntClass)
    )

    val readerParams = Seq[ValDef](
      PARAM("segment", "org.capnproto.SegmentReader"),
      PARAM("data", IntClass),
      PARAM("pointers", IntClass),
      PARAM("dataSize", IntClass),
      PARAM("pointerCount", IntClass),
      PARAM("nestingLimit", IntClass)
    )

    groups.map(g => {
      OBJECTDEF(g.getName.toString()) := BLOCK(
        CLASSDEF("Builder") withParams builderParams withParents (REF("") APPLY builderParams.map(_.name).map(REF)) := BLOCK(

        ),
        CLASSDEF("Reader") withParams readerParams withParents (REF("") APPLY builderParams.map(_.name).map(REF)) := BLOCK(

        )
      )
    })

    val builderCasesTree = group.getStruct.getFields
      .zipWithIndex
      .map{ case (i, n) => CASE(LIT(i)) ==> NEW(REF(name + ".Builder"), REF("segment")) }

    val readerCasesTree = group.getStruct.getFields
      .zipWithIndex
      .map{ case (i, n) => CASE(LIT(i)) ==> NEW(REF(name + ".Reader"), REF("segment")) }

    DEF(name) := (
      REF("_getShortField") APPLY LIT(group.getStruct.getDiscriminantOffset) MATCH builderCasesTree
    )
  }
}
