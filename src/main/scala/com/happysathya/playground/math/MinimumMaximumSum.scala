package com.happysathya.playground.math

import scala.annotation.tailrec

object MinimumMaximumSum:

  def minimumMaximumSum(arr: Array[Int]): (Long, Long) =

    @tailrec
    def minimumMaximumSum(
        arr: Array[Int],
        sum: Long,
        minimum: Long,
        maximum: Long
    ): (Long, Long) =
      if arr.isEmpty then (sum - maximum, sum - minimum)
      else
        val item             = arr.head
        val newMinimum: Long = if minimum == 0 || item < minimum then item else minimum
        val newMaximum: Long = if maximum == 0 || item > maximum then item else maximum
        minimumMaximumSum(arr.tail, sum + item, newMinimum, newMaximum)

    val (min, max) = minimumMaximumSum(arr, 0, 0, 0)
    println(s"$min $max")
    (min, max)
