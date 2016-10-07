package org.capnproto

trait PointerFactory[Builder, Reader] extends FromPointerBuilder[Builder] with FromPointerReader[Reader]

trait PointerFactoryTF extends FromPointerBuilderTF with FromPointerReaderTF {
  type Builder
  type Reader
}
