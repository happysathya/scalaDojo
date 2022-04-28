package com.happysathya.playground

import com.happysathya.playground.BinaryGap.binaryGap
import org.scalatest.funsuite.AnyFunSuite

class BinaryGapTest extends AnyFunSuite {

  test("BinaryGap") {
    assert(binaryGap(0) == 0)
    assert(binaryGap(3) == 0)
    assert(binaryGap(1041) == 5)
    assert(binaryGap(529) == 4)
    assert(binaryGap(15) == 0)
  }
}
