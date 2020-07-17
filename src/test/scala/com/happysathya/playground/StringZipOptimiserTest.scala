package com.happysathya.playground

import com.happysathya.playground.StringZipOptimiser.optimisedZip
import org.scalatest.FunSuite

class StringZipOptimiserTest extends FunSuite {

  test("should return optimised string after removing n characters") {
    assert(optimisedZip("aaaabbbbaaaaacc", 4) == ("a9c2", (4, 7)))
    assert(optimisedZip("aaaaddddaa", 2) == ("a4d4", (8, 9)))
    assert(optimisedZip("aaabbbcccddd", 2) == ("a3b3c3d1", (10, 11)))
  }
}
