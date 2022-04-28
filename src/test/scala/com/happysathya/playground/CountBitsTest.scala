package com.happysathya.playground

import com.happysathya.playground.CountBits.countBits
import org.scalatest.funsuite.AnyFunSuite

class CountBitsTest extends AnyFunSuite {

  test("Count bits") {
    assert(countBits(5) == 2)
    assert(countBits(4) == 1)
  }
}
