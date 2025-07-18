package com.happysathya.playground.algorithms

object RightShiftByNTimes:

  def rightShiftByNTimes(array: Array[Int], k: Int): Array[Int] =
    if k == 0 then array
    else
      array match
        case a if a.isEmpty || a.tail.isEmpty => a
        case a =>
          val b = a.reverse
          rightShiftByNTimes(b.head +: b.tail.reverse, k - 1)
