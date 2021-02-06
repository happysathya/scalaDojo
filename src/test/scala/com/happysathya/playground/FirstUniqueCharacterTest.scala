package com.happysathya.playground

import com.happysathya.playground.FirstUniqueCharacter.findFirstUniqueCharacter
import org.scalatest.FunSuite

class FirstUniqueCharacterTest extends FunSuite {

  test("findFirstUniqueCharacter") {
    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABBAEHF")
      assert(result.isRight)
      assert(result.right.get == 'E')
    }
    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABC")
      assert(result.isRight)
      assert(result.right.get == 'A')
    }
    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABBA")
      assert(result.isLeft)
      assert(result.left.get == "No unique characters")
    }
  }

}
