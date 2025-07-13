package com.happysathya.playground.puzzles

object UnPaired:

  def unpaired(a: Array[Int]): Int =
    a.reduceLeft(_ ^ _)
