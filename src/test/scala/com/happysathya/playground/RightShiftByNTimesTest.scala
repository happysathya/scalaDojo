package com.happysathya.playground

import com.happysathya.playground.RightShiftByNTimes.rightShiftByNTimes
import org.scalatest.FunSuite

class RightShiftByNTimesTest extends FunSuite {

  test("RightShiftByNTimes") {
    assert(rightShiftByNTimes(Array(3, 8, 9, 7, 6), 3) sameElements Array(9, 7, 6, 3, 8))
    assert(rightShiftByNTimes(Array(1), 2) sameElements Array(1))
    assert(rightShiftByNTimes(Array[Int](), 5) sameElements Array[Int]())
  }
}
