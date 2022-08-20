package com.happysathya.playground

import com.happysathya.playground.MaxCounters.maxCounters
import weaver.SimpleIOSuite

object MaxCountersTest extends SimpleIOSuite:

  test("MaxCounters") {
    for
      result1 <- maxCounters(5, Array(3, 4, 4, 6, 1, 4, 4))
      result2 <- maxCounters(2, Array())
    yield expect.all(
      result1 sameElements Array(3, 2, 2, 4, 2),
      result2 sameElements Array(0, 0)
    )
  }
