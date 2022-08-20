package com.happysathya.playground

import scala.annotation.tailrec

object ListCalculator:

  def divide(data: List[Int]): Double =
    data match
      case Nil => 0
      case head :: tail =>
        tail.foldLeft(head.toDouble)((result: Double, item: Int) => result / item)

  def product(data: List[Int]): Long =

    @tailrec
    def productInternal(data: List[Int], acc: Long): Long =
      data match
        case Nil          => acc
        case head :: tail => productInternal(tail, acc * head)

    productInternal(data, 1)

  def sum(data: List[Int]): Long =

    @tailrec
    def sumInternal(data: List[Int], acc: Long): Long =
      data match
        case Nil          => acc
        case head :: tail => sumInternal(tail, acc + head)

    sumInternal(data, 0)
