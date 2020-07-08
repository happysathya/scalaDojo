package com.happysathya.playground

import scala.annotation.tailrec

object CodeWars {

  def countBits(n: Int): Int = {

    def countBits(n: Int, acc: String): String = {
      if (n == 0)
        return acc
      else
        countBits(n / 2, (n % 2) + acc)
    }

    countBits(n, "").toList.count(c => c == '1')
  }

  def sqInRect(length: Int, width: Int): Array[Int] = {

    def min(length: Int, width: Int): Int = {
      if (length < width) length else width
    }

    @tailrec
    def sqInReact(length: Int, width: Int, remainingArea: Int, acc: Array[Int]): Array[Int] = {
      if (remainingArea == 0)
        acc
      else {
        val numberToBeSquared = min(length, width)
        val (newLength: Int, newWidth: Int) = if (length > width) (length - numberToBeSquared, width) else (length, width - numberToBeSquared)
        sqInReact(newLength, newWidth, remainingArea - numberToBeSquared * numberToBeSquared, acc.appended(numberToBeSquared))
      }
    }

    if (length == width)
      Array.emptyIntArray
    else
      sqInReact(length, width, length * width, Array.emptyIntArray)
  }

  def persistence(n: Int): Int = {

    def persistence(n: Int, count: Int): Int = {
      val dataList = s"$n".map(c => c.toString.toInt)
      if (dataList.size == 1)
        count
      else persistence(dataList.product, count + 1)
    }

    persistence(n, 0)
  }

  def order(str: String): String = {
    str
      .trim
      .split(' ')
      .filter(str => !str.isEmpty)
      .map(str => (s"${str.find(c => c.isDigit).get}$str", str))
      .sortBy(t => t._1)
      .map(t => t._2)
      .mkString(" ")
  }

}
