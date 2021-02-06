package com.happysathya.playground

import com.happysathya.playground.SmallPositiveInteger.smallestPositiveInteger
import org.scalatest.FunSuite

class SmallPositiveIntegerTest extends FunSuite {

  test("SmallestPositiveInteger") {
    assert(smallestPositiveInteger(Array(4, 6, 7)) == 1)
    assert(smallestPositiveInteger(Array(-1, -3)) == 1)
    assert(smallestPositiveInteger(Array(1, 3, 6, 4, 1, 2)) == 5)
    assert(smallestPositiveInteger(Array(1, 2, 3)) == 4)
    assert(smallestPositiveInteger(Array(0, -4, -3)) == 1)
    assert(smallestPositiveInteger(Array(2)) == 1)
  }
}
