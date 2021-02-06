package com.happysathya.playground

object MissingElement {

  def missingElement(a: Array[Int]): Int = {
    Math.subtractExact((a.length + 1L) * (a.length + 2L) / 2L, a.map(_.toLong).sum).toInt
  }
}
