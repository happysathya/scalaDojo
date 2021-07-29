package com.happysathya.playground

import com.happysathya.playground.FirstUniqueCharacter.findFirstUniqueCharacter
import com.happysathya.playground.FirstUniqueCharacter.findFirstUniqueCharacterUsingLinkedHashMap
import org.scalatest.FunSuite

class FirstUniqueCharacterTest extends FunSuite {

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

}
