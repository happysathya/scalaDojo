package com.happysathya.playground

import scala.annotation.tailrec

object MinimumMaximumSum {

  def minimumMaximumSum(arr: Array[Int]): (Long, Long) = {

    @tailrec
    def minimumMaximumSum(
      arr: Array[Int],
      sum: Long,
      minimum: Long,
      maximum: Long
    ): (Long, Long) = {
      if (arr.isEmpty)
        (sum - maximum, sum - minimum)
      else {
        val item       = arr.head
        val newMinimum = if (minimum == 0 || item < minimum) item else minimum
        val newMaximum = if (maximum == 0 || item > maximum) item else maximum
        minimumMaximumSum(arr.tail, sum + item, newMinimum, newMaximum)
      }
    }

    val (min, max) = minimumMaximumSum(arr, 0, 0, 0)
    println(s"$min $max")
    (min, max)
  }

}
