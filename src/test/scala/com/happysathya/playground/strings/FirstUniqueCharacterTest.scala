package com.happysathya.playground.strings

import com.happysathya.playground.strings.FirstUniqueCharacter.findFirstUniqueCharacter
import com.happysathya.playground.strings.FirstUniqueCharacter.findFirstUniqueCharacterUsingLinkedHashMap
import org.scalatest.funsuite.AnyFunSuite

class FirstUniqueCharacterTest extends AnyFunSuite:

  test("findFirstUniqueCharacter") {
    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABBAEHF")
      assert(result.fold(_ => throw new RuntimeException, identity) == 'E')
    }
    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABC")
      assert(result.fold(_ => throw new RuntimeException, identity) == 'A')
    }
    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABBA")
      assert(result.fold(identity, _ => throw new RuntimeException) == "No unique characters")
    }
  }

  test("findFirstUniqueCharacter using linkedHashMap") {
    {
      val result: Either[String, Char] = findFirstUniqueCharacterUsingLinkedHashMap("ABBAEHF")
      assert(result.fold(_ => throw new RuntimeException, identity) == 'E')
    }
    {
      val result: Either[String, Char] = findFirstUniqueCharacterUsingLinkedHashMap("ABC")
      assert(result.fold(_ => throw new RuntimeException, identity) == 'A')
    }
    {
      val result: Either[String, Char] = findFirstUniqueCharacterUsingLinkedHashMap("ABBA")
      assert(result.fold(identity, _ => throw new RuntimeException) == "No unique characters")
    }
  }
end FirstUniqueCharacterTest
