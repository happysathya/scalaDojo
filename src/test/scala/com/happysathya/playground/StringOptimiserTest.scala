package com.happysathya.playground

import weaver.SimpleIOSuite

object StringOptimiserTest extends SimpleIOSuite {

  simpleTest("String optimise") {
    for {
      result1 <- StringOptimiser.optimise("")
      result2 <- StringOptimiser.optimise("aa")
      result3 <- StringOptimiser.optimise("aaaabbbcca")
      result4 <- StringOptimiser.optimise("aba")
      result5 <- StringOptimiser.optimise("a")
    } yield expect.all(
      result1 == List.empty,
      result2 == List(('a', 2)),
      result3 == List(('a', 4), ('b', 3), ('c', 2), ('a', 1)),
      result4 == List(('a', 1), ('b', 1), ('a', 1)),
      result5 == List(('a', 1))
    )
  }
}
