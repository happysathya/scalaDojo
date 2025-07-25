package com.happysathya.playground.strings

import com.happysathya.playground.strings.StringToCamelCase.toCamelCase
import org.scalatest.funsuite.AnyFunSuite

class StringToCamelCaseTest extends AnyFunSuite:

  test("should convert strings with dash and underscore delimited to camel case") {
    assert(toCamelCase("The_Stealth_Warrior") == "TheStealthWarrior")
    assert(toCamelCase("the-stealth-warrior") == "theStealthWarrior")
    assert(toCamelCase("the-") == "the")
    assert(toCamelCase("The-") == "The")
    assert(toCamelCase("helloWorld") == "helloWorld")
    assert(toCamelCase("a") == "a")
  }
