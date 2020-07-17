package com.happysathya.playground

object MoveZerosToEnd {

  def moveZerosToEnd(list: List[Any]): List[Any] = {
    val (first, second) = list.partition {
      case a: Int if a == 0 => true
      case _ => false
    }
    second ++ first
  }
}
