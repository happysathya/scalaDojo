package com.happysathya.playground

import com.happysathya.playground.MissingElement.missingElement
import org.scalatest.funsuite.AnyFunSuite

class MissingElementTest extends AnyFunSuite:

  test("MissingElement") {
    assert(missingElement(Array(2, 3, 1, 5)) == 4)
    assert(missingElement(Array()) == 1)
    assert(missingElement(Array(1)) == 2)
  }
