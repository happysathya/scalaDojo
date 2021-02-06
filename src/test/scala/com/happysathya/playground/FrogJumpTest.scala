package com.happysathya.playground

import com.happysathya.playground.FrogJump.frogJump
import org.scalatest.FunSuite

class FrogJumpTest extends FunSuite {

  test("FrogJump") {
    assert(frogJump(10, 85, 30) == 3)
    assert(frogJump(10, 100, 30) == 3)
  }
}
