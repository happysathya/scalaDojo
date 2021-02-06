package com.happysathya.playground

import com.happysathya.playground.UnPaired.unpaired
import org.scalatest.FunSuite

class UnPairedTest extends FunSuite {

  test("UnPaired") {
    assert(unpaired(Array(3, 9, 4, 9, 3)) == 4)
  }
}
