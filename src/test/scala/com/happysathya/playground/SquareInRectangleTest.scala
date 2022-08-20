package com.happysathya.playground

import com.happysathya.playground.SquareInRectangle.sqInRect
import org.scalatest.funsuite.AnyFunSuite

class SquareInRectangleTest extends AnyFunSuite:

  test("SquareInRectangle") {
    assert(sqInRect(5, 3) sameElements Array(3, 2, 1, 1))
    assert(sqInRect(4, 4).isEmpty)
    assert(sqInRect(4, 5) sameElements Array(4, 1, 1, 1, 1))
    assert(sqInRect(20, 14) sameElements Array(14, 6, 6, 2, 2, 2))
  }
