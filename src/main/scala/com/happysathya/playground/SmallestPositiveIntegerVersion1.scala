/*
Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

[1, 3, 6, 4, 1, 2], the function should return 5.
[1, 2, 3], the function should return 4.
[−1, −3], the function should return 1.
 */

package com.happysathya.playground

object SmallestPositiveIntegerVersion1 {

  def smallestPositiveInteger(a: Iterable[Int]): Int = {
    val rangeFrom1ToArraySize = Range.inclusive(1, a.size + 1)
    val setFrom1ToArraySize   = rangeFrom1ToArraySize.toSet
    val differenceSet         = setFrom1ToArraySize diff a.toSet
    differenceSet.min
  }
}
