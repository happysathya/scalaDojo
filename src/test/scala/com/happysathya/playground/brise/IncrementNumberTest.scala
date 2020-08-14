package com.happysathya.playground.brise

import com.happysathya.playground.brise.IncrementNumber.increment
import org.scalatest.FunSuite

class IncrementNumberTest extends FunSuite {

  test("should increment sequence by 1") {
    assert(increment(Seq(5, 4, 3)).unsafeRunSync() == Seq(5, 4, 4))
    assert(increment(Seq(9, 9, 9, 9)).unsafeRunSync() == Seq(1, 0, 0, 0, 0))
    assert(increment(Seq()).unsafeRunSync() == Seq())
    assert(increment(Seq(1)).unsafeRunSync() == Seq(2))
    assert(increment(Seq(9)).unsafeRunSync() == Seq(1, 0))
  }
}
