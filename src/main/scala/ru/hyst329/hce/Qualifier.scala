package ru.hyst329.hce

sealed trait Qualifier

case object All extends Qualifier
case object None extends Qualifier
