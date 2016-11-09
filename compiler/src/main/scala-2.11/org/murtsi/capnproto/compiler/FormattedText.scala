package org.murtsi.capnproto.compiler

import scala.compat.Platform

sealed trait FormattedText {
  def lines(indent: Int = 0): Vector[String]

  def stringify() =
    lines()
      .foldLeft(new StringBuilder)((a, b) => a.append(b).append(Platform.EOL))
      .toString()
}

case class Indent(text: FormattedText) extends FormattedText {
  override def lines(indent: Int): Vector[String] = text.lines(indent+1)
}
case class Branch(texts: FormattedText*) extends FormattedText {
  override def lines(indent: Int): Vector[String] = {
    (for (text <- texts;
         line <- text.lines(indent))
      yield line).toVector
  }
}
case class Line(line: String) extends FormattedText {
  override def lines(indent: Int): Vector[String] =
    Vector(" " * (indent * 2) + line)
}
object BlankLine extends FormattedText {
  override def lines(indent: Int): Vector[String] = Vector("")
}

