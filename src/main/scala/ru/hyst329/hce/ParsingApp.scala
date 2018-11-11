package ru.hyst329.hce

import org.parboiled2.{ErrorFormatter, ParseError, ParserInput}

import scala.util.{Failure, Success}

object ParsingApp extends App {
  val input = "no blue book inserts big mouse."
  val parser = new HCEParser(input).sentence.run()
  parser match {
    case Success(res) => println(res)
    case Failure(ex @ ParseError(_, _, _)) => println((new ErrorFormatter).format(ex, input))
    case Failure(ex) => sys.error(s"Unhandled exception: $ex")
  }
}
