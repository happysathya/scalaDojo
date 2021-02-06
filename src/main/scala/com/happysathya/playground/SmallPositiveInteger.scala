package com.happysathya.playground

object SmallPositiveInteger {

  def smallestPositiveInteger(a: Array[Int]): Int = {
    (Range(1, a.length + 2).toSet diff a.toSet).min
  }
}
