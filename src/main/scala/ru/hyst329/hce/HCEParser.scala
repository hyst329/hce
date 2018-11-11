package ru.hyst329.hce
import org.parboiled2._

class HCEParser(val input: ParserInput) extends Parser {
  def file = rule {
    zeroOrMore(sentence) ~ EOI
  }

  def sentence = rule {
    qualifier ~ `object` ~ verb ~ `object`
  }

  def qualifier = rule {
    atomic("all") | atomic("no")
  }


  def noun = rule {
    ???
  }

  def verb = rule {
    ???
  }

  def adjective = rule {
    ???
  }

  def `object` = rule {
    oneOrMore(adjective) ~ noun
  }

  def word = rule {
    oneOrMore(CharPredicate.AlphaNum)
  }
}
