package org.murtsi.capnproto.runtime

trait Arena {

  def tryGetSegment(id: Int): SegmentReader

  def checkReadLimit(numBytes: Int): Unit
}
