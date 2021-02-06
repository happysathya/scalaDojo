package com.happysathya.playground

import com.happysathya.playground.WordOrdering.order
import org.scalatest.FunSuite

class WordOrderingTest extends FunSuite {

  test("WordOrdering") {
    assert(order("is2 Thi1s T4est 3a") == "Thi1s is2 3a T4est")
    assert(order("") == "")
  }

}
