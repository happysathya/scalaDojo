package com.happysathya.playground

import com.happysathya.playground.IterablePairWithNextElement.pairWithNextElement
import org.scalatest.FunSuite

class IterablePairWithNextElementTest extends FunSuite {

  test("pair with next element") {
    assert(pairWithNextElement(List.empty[Int]) == List.empty)
    assert(pairWithNextElement(List(1)) == List.empty)
    assert(pairWithNextElement(List(1, 2)) == List((1, 2)))
    assert(pairWithNextElement(List(1, 2, 3)) == List((1, 2), (2, 3)))
    assert(pairWithNextElement(List(1, 2, 3, 4)) == List((1, 2), (2, 3), (3, 4)))
  }
}
