package com.happysathya.playground

import com.happysathya.playground.LonelyInteger.lonelyInteger
import org.scalatest.funsuite.AnyFunSuite

class LonelyIntegerTest extends AnyFunSuite:

  test("find lonely number in an array") {
    assert(lonelyInteger(Array(0, 0, 1, 2, 1)) == 2)
    assert(lonelyInteger(Array(1, 1, 2)) == 2)
    assert(lonelyInteger(Array(1)) == 1)
  }
