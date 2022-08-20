package com.happysathya.playground

import com.happysathya.playground.DataCleanup.{emailSpecialCharactersCleanup, mergeMaps}
import org.scalatest.funsuite.AnyFunSuite

class DataCleanupTest extends AnyFunSuite:

  test("should cleanup email special characters") {
    assert(emailSpecialCharactersCleanup("abcd@efg.com") == "abcd@efg.com")
    assert(emailSpecialCharactersCleanup("ab-cd@efg.com") == "abcd@efg.com")
    assert(emailSpecialCharactersCleanup("ab-c/d@efg.com") == "abcd@efg.com")
    assert(emailSpecialCharactersCleanup("abcd.efg@efg.com") == "abcdefg@efg.com")
  }

  test("should merge maps by their keys and aggregate score") {
    assert(
      mergeMaps(
        Seq(
          Map("100" -> 100, "11" -> 50), // union 1
          Map("100" -> 200, "11" -> 50, "3" -> 50) // union 2
        ),
        100
      ) == 11
    )

    /*
      2 => [2, 4, 6] => 2
      4 => [2, 4, 6] => 2
      5 => [5, 6] => 5
      6 => [5, 6, 2, 4] => 2

      n => p

      2 => P6
      4 => P1
      5 => P2
      6 => P3

      2 => [P6, P1, P3] => p1
      4 => [P6, P1, P3] => p1
      5 => [P2, P3]     => p2
      6 => [P6, P1, P3, P2] => p1

      P6 < P2 < P5

      2 => [P2, P4, P6] => P6
      4 => [P2, P4, P6] => P6
      5 => [P5, P6] => P6
      6 => [P2, P4, P6, P5] => P6
     */

  }
end DataCleanupTest
