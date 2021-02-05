package com.happysathya.playground.brise

import com.happysathya.playground.brise.IncrementNumber.increment
import weaver.SimpleIOSuite

object IncrementNumberTest extends SimpleIOSuite {

  simpleTest("should increment sequence by 1") {
    for {
      a1 <- increment(Seq(5, 4, 3))
      a2 <- increment(Seq(9, 9, 9, 9))
      a3 <- increment(Seq())
      a4 <- increment(Seq(1))
      a5 <- increment(Seq(9))
    } yield expect.all(
      a1 == Seq(5, 4, 4), //expected input must be 5, 4, 3
      a2 == Seq(1, 0, 0, 0, 0),
      a3 == Seq(),
      a4 == Seq(2),
      a5 == Seq(1, 0)
    )
  }
}
