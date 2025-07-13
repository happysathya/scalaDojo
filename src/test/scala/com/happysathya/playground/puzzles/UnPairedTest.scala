package com.happysathya.playground.puzzles

import com.happysathya.playground.puzzles.UnPaired.unpaired
import org.scalatest.funsuite.AnyFunSuite

class UnPairedTest extends AnyFunSuite:

  test("UnPaired") {
    assert(unpaired(Array(3, 9, 4, 9, 3)) == 4)
  }
