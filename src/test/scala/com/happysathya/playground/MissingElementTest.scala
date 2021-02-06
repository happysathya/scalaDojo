package com.happysathya.playground

import com.happysathya.playground.MissingElement.missingElement
import org.scalatest.FunSuite

class MissingElementTest extends FunSuite {

  test("MissingElement") {
    assert(missingElement(Array(2, 3, 1, 5)) == 4)
    assert(missingElement(Array()) == 1)
    assert(missingElement(Array(1)) == 2)
  }
}
