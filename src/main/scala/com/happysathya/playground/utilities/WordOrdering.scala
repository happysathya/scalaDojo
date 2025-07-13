package com.happysathya.playground.utilities

object WordOrdering:

  def order(str: String): String =
    str.trim
      .split(' ')
      .filter(str => str.nonEmpty)
      .map(str => (s"${str.find(c => c.isDigit).get}$str", str))
      .sortBy(t => t._1)
      .map(t => t._2)
      .mkString(" ")
