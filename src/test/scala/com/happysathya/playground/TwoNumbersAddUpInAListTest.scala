package com.happysathya.playground

import weaver.SimpleIOSuite

object TwoNumbersAddUpInAListTest extends SimpleIOSuite:

  test("Should return boolean if TwoNumbersAddUpTo a sum in a list") {
    for
      result1 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(1, 2, 3), 5)
      result2 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(1, 2, 3), 4)
      result3 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(), 10)
      result4 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(10, 15, 3, 7), 17)
      result5 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(5, 0, 1, 2), 5)
      result6 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(10, -2, 1, 2), 8)
    yield expect.all(
      result1,
      result2,
      !result3,
      result4,
      result5,
      result6
    )
  }
