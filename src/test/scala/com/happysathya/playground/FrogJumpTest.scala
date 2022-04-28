package com.happysathya.playground

import com.happysathya.playground.FrogJump.frogJump
import org.scalatest.funsuite.AnyFunSuite

class FrogJumpTest extends AnyFunSuite {

  test("FrogJump") {
    assert(frogJump(10, 85, 30) == 3)
    assert(frogJump(10, 100, 30) == 3)
  }
}
