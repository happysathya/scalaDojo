package com.happysathya.playground.utilities

import com.happysathya.playground.utilities.FindWordPrecedenceRule.findWord
import org.scalatest.funsuite.AnyFunSuite

class FindWordPrecedenceRuleTest extends AnyFunSuite:

  test("find the correct word using the precedence rule") {
    assert(findWord(List("P>E", "E>R", "R>U")) == "PERU")
    assert(findWord(List("I>N", "A>I", "P>A", "S>P")) == "SPAIN")
    assert(findWord(List("I>F", "W>I", "S>W", "F>T")) == "SWIFT")
    assert(findWord(List("R>T", "A>L", "P>O", "O>R", "G>A", "T>U", "U>G")) == "PORTUGAL")
    assert(findWord(List("U>N", "G>A", "R>Y", "H>U", "N>G", "A>R")) == "HUNGARY")
    assert(
      findWord(
        List("W>I", "R>L", "T>Z", "Z>E", "S>W", "E>R", "L>A", "A>N", "N>D", "I>T")
      ) == "SWITZERLAND"
    )
  }
