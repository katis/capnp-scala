package org.katis.capnproto.runtime

object ReaderOptions {

  val DEFAULT_TRAVERSAL_LIMIT_IN_WORDS = 8 * 1024 * 1024

  val DEFAULT_NESTING_LIMIT = 64

  val DEFAULT_READER_OPTIONS = new ReaderOptions(DEFAULT_TRAVERSAL_LIMIT_IN_WORDS, DEFAULT_NESTING_LIMIT)
}

class ReaderOptions(val traversalLimitInWords: Long, val nestingLimit: Int)
