package com.happysathya.playground

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

class LowestNumberInConstantTime {

  private val stack = new mutable.Stack[(Int, Int)]()

  def push(value: Int): Unit = {
    if (stack.isEmpty) {
      stack.push((value, value))
    } else {
      val top            = stack.top
      val lastElementLow = top._2
      val newLow         = if (value < lastElementLow) value else lastElementLow
      stack.push((value, newLow))
    }
  }

  def pop(): Try[Int] = {
    if (stack.isEmpty) {
      Failure(new RuntimeException("stack is empty"))
    } else {
      Success(stack.pop()._1)
    }
  }

  def lowestValue(): Try[Int] = {
    if (stack.isEmpty) {
      Failure(new RuntimeException("stack is empty"))
    } else {
      Success(stack.top._2)
    }
  }

  def pushAll(values: IterableOnce[Int]): Unit = {
    values.iterator.foreach(value => push(value))
  }
}
