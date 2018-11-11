package ru.hyst329.hce

trait Sentence

case class LogicSentence(qualifier: Qualifier,
                         entity1: Entity,
                         verb: String,
                         entity2: Entity) extends Sentence