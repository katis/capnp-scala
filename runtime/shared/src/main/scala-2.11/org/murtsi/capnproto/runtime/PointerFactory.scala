package org.murtsi.capnproto.runtime

trait PointerFactory extends FromPointerBuilder with FromPointerReader {
  type Builder
  type Reader
}
