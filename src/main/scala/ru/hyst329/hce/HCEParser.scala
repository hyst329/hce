package ru.hyst329.hce
import org.parboiled2._

class HCEParser(val input: ParserInput) extends Parser {

  def file: Rule1[Seq[Sentence]] = rule {
    zeroOrMore(sentence).separatedBy(ws) ~ EOI
  }

  def sentence: Rule1[Sentence] = rule {
    qualifier ~ `object` ~ verb ~ `object` ~ '.' ~>
      ((q: Qualifier, e1: Entity, v: String, e2: Entity) => LogicSentence(q, e1, v, e2))
  }

  def qualifier: Rule1[Qualifier] = rule {
    (atomic("all") ~> (() => All)) | (atomic("no") ~> (() => None)) ~ ws
  }

  def noun: Rule1[String] = rule {
    word ~> ((w: String) => test(HCEKnowledgeBase.nounSingulars.contains(w)) ~ push(w))
  }

  def verb: Rule1[String] = rule {
    v0 | v1
  }

  def v0: Rule1[String] = rule {
    word ~> ((w: String) => test(HCEKnowledgeBase.v0s.contains(w)) ~ push(w))
  }

  def v1: Rule1[String] = rule {
    word ~> ((w: String) => test(HCEKnowledgeBase.v1s.contains(w)) ~ push(w))
  }

  def v2: Rule1[String] = rule {
    word ~> ((w: String) => test(HCEKnowledgeBase.v2s.contains(w)) ~ push(w))
  }

  def v3: Rule1[String] = rule {
    word ~> ((w: String) => test(HCEKnowledgeBase.v3s.contains(w)) ~ push(w))
  }

  def v4: Rule1[String] = rule {
    word ~> ((w: String) => test(HCEKnowledgeBase.v4s.contains(w)) ~ push(w))
  }

  def adjective: Rule1[String] = rule {
    !noun ~ word
  }

  def `object`: Rule1[Entity] = rule {
    zeroOrMore(adjective) ~ noun ~> ((as: Seq[String], n: String) => Entity(as.toList, n))
  }

  def word: Rule1[String] = rule {
    capture(oneOrMore(CharPredicate.AlphaNum)) ~ ws
  }

  def ws: Rule0 = rule {
    quiet(zeroOrMore(anyOf(" \t \n")))
  }
}
