package org.capnproto

trait Arena {

  def tryGetSegment(id: Int): SegmentReader

  def checkReadLimit(numBytes: Int): Unit
}
