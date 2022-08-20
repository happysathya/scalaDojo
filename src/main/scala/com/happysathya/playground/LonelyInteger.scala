package com.happysathya.playground

object LonelyInteger:

  def lonelyInteger(array: Array[Int]): Int =
    array.foldLeft(0)((prev: Int, next: Int) => prev ^ next)
