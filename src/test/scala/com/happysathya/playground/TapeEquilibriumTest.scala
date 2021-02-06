package com.happysathya.playground

import com.happysathya.playground.TapeEquilibrium.tapeEquilibrium
import org.scalatest.FunSuite

class TapeEquilibriumTest extends FunSuite {

  test("TapeEquilibrium") {
    assert(tapeEquilibrium(Array(3, 1, 2, 4, 3)) == 1)
    assert(tapeEquilibrium(Array(1, 3)) == 2)
    assert(tapeEquilibrium(Array(3, 1)) == 2)
    assert(tapeEquilibrium(Array(0, 1)) == 1)
    assert(tapeEquilibrium(Array(1, 0)) == 1)
    assert(tapeEquilibrium(Array(-1, 2)) == 3)
    assert(tapeEquilibrium(Array(-3, -2, -1)) == 0)
    assert(tapeEquilibrium(Array(-1, -2, 5)) == 4)
  }
}
