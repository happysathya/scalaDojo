package com.happysathya.playground

import org.scalatest.FunSuite

class LowestNumberInConstantTimeTest extends FunSuite {

  test("LowestNumberInConstantTime") {
    {
      val lowestNumberInConstantTime = new LowestNumberInConstantTime()

      lowestNumberInConstantTime.push(5)

      assert(lowestNumberInConstantTime.lowestValue().get == 5)

      lowestNumberInConstantTime.push(1)
      lowestNumberInConstantTime.push(2)

      assert(lowestNumberInConstantTime.lowestValue().get == 1)

      lowestNumberInConstantTime.push(0)

      assert(lowestNumberInConstantTime.lowestValue().get == 0)

      lowestNumberInConstantTime.pop()
      assert(lowestNumberInConstantTime.lowestValue().get == 1)
    }

    {
      val lowestNumberInConstantTime = new LowestNumberInConstantTime()

      lowestNumberInConstantTime.pushAll(List(3, 1, 2, 5, 3, 2))

      assert(lowestNumberInConstantTime.lowestValue().get == 1)
    }
  }

}
