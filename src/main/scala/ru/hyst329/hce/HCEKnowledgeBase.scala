package ru.hyst329.hce

import java.sql.DriverManager

object HCEKnowledgeBase {
  private val con = DriverManager.getConnection("jdbc:sqlite:kb.sqlite3")

  lazy val verbs: List[List[String]] = {
    val rs = con.createStatement.executeQuery("SELECT v0, v1, v2, v3, v4 FROM verbs")
    var list: List[List[String]] = List.empty
    while (rs.next()) {
      list +:= List(
        rs.getString(1),
        rs.getString(2),
        rs.getString(3),
        rs.getString(4),
        rs.getString(5)
      )
    }
    list
  }
  lazy val nouns: List[List[String]] = {
    val rs = con.createStatement.executeQuery("SELECT singular, plural FROM nouns")
    var list: List[List[String]] = List.empty
    while (rs.next()) {
      list +:= List(rs.getString(1), rs.getString(2))
    }
    list
  }
}
