package com.happysathya.playground.collections

import com.happysathya.playground.collections.MoveZerosToEnd.moveZerosToEnd
import org.scalatest.funsuite.AnyFunSuite

class MoveZerosToEndTest extends AnyFunSuite:

  test("should move zeroes to end of list") {
    assert(moveZerosToEnd(List(1, 2, 3)) == List(1, 2, 3))
    assert(moveZerosToEnd(List("false", 1, 2)) == List("false", 1, 2))
    assert(moveZerosToEnd(List("false", 0, 1, 0, 2)) == List("false", 1, 2, 0, 0))
    assert(moveZerosToEnd(List.empty) == List.empty)
  }
