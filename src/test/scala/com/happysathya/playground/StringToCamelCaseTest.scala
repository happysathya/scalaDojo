package com.happysathya.playground

import com.happysathya.playground.StringToCamelCase.toCamelCase
import org.scalatest.FunSuite

class StringToCamelCaseTest extends FunSuite {

  test("should convert strings with dash and underscore delimited to camel case") {
    assert(toCamelCase("The_Stealth_Warrior") == "TheStealthWarrior")
    assert(toCamelCase("the-stealth-warrior") == "theStealthWarrior")
    assert(toCamelCase("the-") == "the")
    assert(toCamelCase("The-") == "The")
    assert(toCamelCase("helloWorld") == "helloWorld")
    assert(toCamelCase("a") == "a")
  }
}
