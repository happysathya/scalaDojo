/*
Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

[1, 3, 6, 4, 1, 2], the function should return 5.
[1, 2, 3], the function should return 4.
[−1, −3], the function should return 1.
 */

package com.happysathya.playground

import scala.annotation.tailrec
import scala.collection.immutable.{HashSet, TreeSet}

object SmallestPositiveIntegerVersion2:

  def smallestPositiveInteger(array: Iterable[Int]): Int =
    @tailrec
    def smallestPositiveInteger(
        items: Iterable[Int],
        acc: HashSet[Int],
        result: TreeSet[Int]
    ): Int =
      items.headOption match
        case Some(value) =>
          val newResult =
            value match
              case x if acc.contains(x)    => result
              case x if result.contains(x) => result.excl(value)
              case x =>
                val nearByValues         = previousAndNextElement(x)
                val filteredNearByValues = nearByValues.diff(acc)
                result.concat(filteredNearByValues)
          smallestPositiveInteger(items.tail, acc.incl(value), newResult)
        case None => result.headOption.fold(1)(x => if acc.contains(1) then x else 1)

    def previousAndNextElement(value: Int): Set[Int] =
      value match
        case x if x <= 0 => Set(1)
        case x           => Set(if x == 1 then x + 1 else x - 1, x + 1)

    smallestPositiveInteger(array, HashSet.empty[Int], TreeSet())
