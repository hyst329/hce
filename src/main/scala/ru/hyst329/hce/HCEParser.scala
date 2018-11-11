package ru.hyst329.hce
import org.parboiled2._

class HCEParser(val input: ParserInput) extends Parser {

  def file = rule {
    zeroOrMore(sentence) ~ EOI
  }

  def sentence = rule {
    qualifier ~ `object` ~ verb ~ `object` ~ '.'
  }

  def qualifier = rule {
    atomic("all") | atomic("no")
  }

  def noun = rule {
    word
  }

  def verb = rule {
    word
  }

  def adjective = rule {
    word
  }

  def `object` = rule {
    oneOrMore(adjective) ~ noun
  }

  def word = rule {
    oneOrMore(CharPredicate.AlphaNum) ~ ws
  }

  def ws = rule {
    quiet(zeroOrMore(anyOf(" \t \n")))
  }
}
