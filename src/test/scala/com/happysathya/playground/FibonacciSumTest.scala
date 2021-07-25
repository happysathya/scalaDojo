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
    
    for {
      result1 <- FibonacciSum.fibonacciSumUsingRecursion(0)
      result2 <- FibonacciSum.fibonacciSumUsingRecursion(1)
      result3 <- FibonacciSum.fibonacciSumUsingRecursion(2)
      result4 <- FibonacciSum.fibonacciSumUsingRecursion(5)
      result5 <- FibonacciSum.fibonacciSumUsingRecursion(6)
      result6 <- FibonacciSum.fibonacciSumUsingRecursion(-1).attempt
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
    for {
      result1 <- FibonacciSum.fibonacciSumUsingTailRecursion(0)
      result2 <- FibonacciSum.fibonacciSumUsingTailRecursion(1)
      result3 <- FibonacciSum.fibonacciSumUsingTailRecursion(2)
      result4 <- FibonacciSum.fibonacciSumUsingTailRecursion(5)
      result5 <- FibonacciSum.fibonacciSumUsingTailRecursion(6)
      result6 <- FibonacciSum.fibonacciSumUsingTailRecursion(-1).attempt
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
