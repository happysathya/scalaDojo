package com.happysathya.playground

import com.happysathya.playground.SmallestPositiveIntegerVersion2.smallestPositiveInteger
import org.scalatest.funsuite.AnyFunSuite

class SmallestPositiveIntegerVersion2Test extends AnyFunSuite:

  test("SmallestPositiveInteger") {
    assert(smallestPositiveInteger(Range.inclusive(-1000000, 1000000)) == 1000001)
    assert(smallestPositiveInteger(Array(1, 3, 6, 4, 1, 2)) == 5)
    assert(smallestPositiveInteger(Array(1, 4, 6, 3, 1, 2)) == 5)
    assert(smallestPositiveInteger(Array(1)) == 2)
    assert(smallestPositiveInteger(Array(1, 2, 3)) == 4)
    assert(smallestPositiveInteger(Array(-1, -3)) == 1)
    assert(smallestPositiveInteger(Array(0, -4, -3)) == 1)
    assert(smallestPositiveInteger(Array(2)) == 1)
    assert(smallestPositiveInteger(Array(4, 6, 7)) == 1)
    assert(smallestPositiveInteger(Array(4, 6, 7, 2)) == 1)
    assert(smallestPositiveInteger(Array(4, 6, 7, 1)) == 2)
  }
