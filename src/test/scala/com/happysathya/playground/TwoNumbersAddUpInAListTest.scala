package com.happysathya.playground

import weaver.SimpleIOSuite

object TwoNumbersAddUpInAListTest extends SimpleIOSuite {

  simpleTest("Should return boolean if TwoNumbersAddUpTo a sum in a list") {
    for {
      result1 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(1, 2, 3), 5)
      result2 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(1, 2, 3), 4)
      result3 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(), 10)
      result4 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(10, 15, 3, 7), 17)
      result5 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(5, 0, 1, 2), 5)
      result6 <- TwoNumbersAddUpInAList.isTwoNumbersAddUpTo(List(10, -2, 1, 2), 8)
    } yield expect.all(
      result1 == true,
      result2 == true,
      result3 == false,
      result4 == true,
      result5 == true,
      result6 == true
    )
  }
}
