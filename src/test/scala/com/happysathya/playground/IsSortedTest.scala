package com.happysathya.playground

import com.happysathya.playground.IsSorted.isSorted
import org.scalatest.FunSuite

class IsSortedTest extends FunSuite {

  test("IsSorted for type Int") {
    val ordered: (Int, Int) => Boolean = (a: Int, b: Int) => if (b >= a) true else false
    assert(isSorted(Array(1, 2, 3), ordered))
    assert(!isSorted(Array(1, 3, 2), ordered))
    assert(!isSorted(Array(1, 2, 4, 2), ordered))
    assert(isSorted(Array(10, 21, 21, 22), ordered))
    assert(isSorted(Array.empty[Int], ordered))
    assert(isSorted(Array(1), ordered))
  }

  test("IsSorted for type string") {
    val ordered: (String, String) => Boolean =
      (a: String, b: String) => if (b >= a) true else false
    assert(isSorted(Array("a", "aa", "aaa"), ordered))
    assert(isSorted(Array("ab", "ac", "ac", "ad"), ordered))
    assert(!isSorted(Array("ab", "aa", "ac", "ad"), ordered))
  }
}
