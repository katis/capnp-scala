package org.murtsi.capnproto.compiler

import scala.compat.Platform

sealed trait FormattedText {
  def lines(indent: Int = 0): Seq[String]

  def stringify() =
    lines()
      .foldLeft(new StringBuilder)((a, b) => a.append(b).append(Platform.EOL))
      .toString()
}

case class Indent(text: FormattedText) extends FormattedText {
  override def lines(indent: Int): Seq[String] = text.lines(indent+1)
}
case class Branch(texts: FormattedText*) extends FormattedText {
  override def lines(indent: Int): Seq[String] = {
    for (text <- texts;
         line <- text.lines(indent))
      yield line
  }
}
case class Line(line: String) extends FormattedText {
  override def lines(indent: Int): Seq[String] =
    Seq(" " * (indent * 2) + line)
}
object BlankLine extends FormattedText {
  override def lines(indent: Int): Seq[String] = Seq("")
}

