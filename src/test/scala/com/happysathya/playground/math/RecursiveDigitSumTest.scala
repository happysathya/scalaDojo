package com.happysathya.playground.math

import com.happysathya.playground.math.RecursiveDigitSum.superDigit
import org.scalatest.funsuite.AnyFunSuite

class RecursiveDigitSumTest extends AnyFunSuite:

  test("calculate recursive digit sum for a very long number") {
    assert(superDigit("9578", 4) == 8)
    assert(superDigit("148", 3) == 3)
    assert(superDigit("123", 3) == 9)
  }
