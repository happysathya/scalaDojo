package com.happysathya.playground

import weaver.SimpleIOSuite

object FibonacciSumTest extends SimpleIOSuite {

  simpleTest("fibonacci sum using iterative") {
    import FibonacciSum.{fibonacciSumUsingIterative => fibonacciSum}
    for {
      result1 <- fibonacciSum(0)
      result2 <- fibonacciSum(1)
      result3 <- fibonacciSum(2)
      result4 <- fibonacciSum(5)
      result5 <- fibonacciSum(6)
      result6 <- fibonacciSum(-1).attempt
    } yield {
      expect.all(
        result1 == 0,
        result2 == 1,
        result3 == 1,
        result4 == 5,
        result5 == 8,
        result6.left.exists(e => e.getMessage.contains("n cannot be negative"))
      )
    }
  }

  simpleTest("fibonacci sum using recursion") {
    import FibonacciSum.{fibonacciSumUsingRecursion => fibonacciSum}
    for {
      result1 <- fibonacciSum(0)
      result2 <- fibonacciSum(1)
      result3 <- fibonacciSum(2)
      result4 <- fibonacciSum(5)
      result5 <- fibonacciSum(6)
      result6 <- fibonacciSum(-1).attempt
    } yield {
      expect.all(
        result1 == 0,
        result2 == 1,
        result3 == 1,
        result4 == 5,
        result5 == 8,
        result6.left.exists(e => e.getMessage.contains("n cannot be negative"))
      )
    }
  }

  simpleTest("fibonacci sum using tail recursion") {
    import FibonacciSum.{fibonacciSumUsingTailRecursion => fibonacciSum}
    for {
      result1 <- fibonacciSum(0)
      result2 <- fibonacciSum(1)
      result3 <- fibonacciSum(2)
      result4 <- fibonacciSum(5)
      result5 <- fibonacciSum(6)
      result6 <- fibonacciSum(-1).attempt
    } yield {
      expect.all(
        result1 == 0,
        result2 == 1,
        result3 == 1,
        result4 == 5,
        result5 == 8,
        result6.left.exists(e => e.getMessage.contains("n cannot be negative"))
      )
    }
  }

}
