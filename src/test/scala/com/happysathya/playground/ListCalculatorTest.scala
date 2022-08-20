package com.happysathya.playground

import org.scalatest.funsuite.AnyFunSuite

class ListCalculatorTest extends AnyFunSuite:

  test("ListCalculator") {
    {
      val sum = ListCalculator.sum(List.empty)
      assert(sum == 0)
    }
    {
      val sum = ListCalculator.sum(List(1, 3, 5))
      assert(sum == 9)
    }
    {
      val product = ListCalculator.product(List.empty)
      assert(product == 1)
    }
    {
      val product = ListCalculator.product(List(1, 3, 5))
      assert(product == 15)
    }
    {
      val division = ListCalculator.divide(List.empty)
      assert(division == 0)
    }
    {
      val division = ListCalculator.divide(List(5))
      assert(division == 5)
    }
    {
      val division = ListCalculator.divide(List(1, 3, 5))
      assert(division == 0.06666666666666667)
    }
  }
end ListCalculatorTest
