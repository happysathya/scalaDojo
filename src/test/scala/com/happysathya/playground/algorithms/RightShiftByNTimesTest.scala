package com.happysathya.playground.algorithms

import com.happysathya.playground.algorithms.RightShiftByNTimes.rightShiftByNTimes
import org.scalatest.funsuite.AnyFunSuite

class RightShiftByNTimesTest extends AnyFunSuite:

  test("RightShiftByNTimes") {
    assert(rightShiftByNTimes(Array(3, 8, 9, 7, 6), 3) sameElements Array(9, 7, 6, 3, 8))
    assert(rightShiftByNTimes(Array(1), 2) sameElements Array(1))
    assert(rightShiftByNTimes(Array[Int](), 5) sameElements Array[Int]())
  }
