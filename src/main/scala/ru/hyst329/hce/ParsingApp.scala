package ru.hyst329.hce

object ParsingApp extends App {
  val verbs = HCEKnowledgeBase.verbs
  val nouns = HCEKnowledgeBase.nouns
  println(s"$verbs")
  println(s"$nouns")
}
