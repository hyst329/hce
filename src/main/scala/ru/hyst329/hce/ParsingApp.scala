package ru.hyst329.hce

import org.parboiled2.{ErrorFormatter, ParseError}

import util.{Failure, Success}
import util.control.Breaks._

object ParsingApp extends App {
  breakable {
    while (true) {
      print("> ")
      Console.flush()
      val input = io.StdIn.readLine()
      if (input.isEmpty) break
      val parser = new HCEParser(input).sentence.run()
      parser match {
        case Success(res) => println(res)
        case Failure(ex@ParseError(_, _, _)) => println((new ErrorFormatter).format(ex, input))
        case Failure(ex) => sys.error(s"Unhandled exception: $ex")
      }
    }
  }
}
