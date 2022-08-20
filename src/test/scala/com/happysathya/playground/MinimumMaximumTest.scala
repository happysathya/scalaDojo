package com.happysathya.playground

import com.happysathya.playground.MinimumMaximumSum.minimumMaximumSum
import org.scalatest.funsuite.AnyFunSuite

class MinimumMaximumTest extends AnyFunSuite:

  test("MinimumMaximumTest") {
    assert(minimumMaximumSum(Array(1, 2, 3, 4, 5)) == (10, 14))
  }
