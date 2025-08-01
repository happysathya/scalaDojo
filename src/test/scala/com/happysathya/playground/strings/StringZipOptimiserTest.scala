package com.happysathya.playground.strings

import com.happysathya.playground.strings.StringZipOptimiser.optimisedZip
import org.scalatest.funsuite.AnyFunSuite

class StringZipOptimiserTest extends AnyFunSuite:

  test("should return optimised string after removing n characters") {
    assert(optimisedZip("aaaabbbbaaaaacc", 4) == ("a9c2", (4, 7)))
    assert(optimisedZip("aaaaddddaa", 2) == ("a4d4", (8, 9)))
    assert(optimisedZip("aaabbbcccddd", 2) == ("a3b3c3d1", (10, 11)))
  }
