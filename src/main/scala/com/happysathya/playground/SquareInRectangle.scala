package com.happysathya.playground

import scala.annotation.tailrec

object SquareInRectangle {

  def sqInRect(length: Int, width: Int): Array[Int] = {

    def min(length: Int, width: Int): Int = {
      if (length < width) length else width
    }

    @tailrec
    def sqInRect(length: Int, width: Int, remainingArea: Int, acc: Array[Int]): Array[Int] = {
      if (remainingArea == 0)
        acc
      else {
        val numberToBeSquared = min(length, width)
        val (newLength: Int, newWidth: Int) =
          if (length > width) (length - numberToBeSquared, width)
          else (length, width - numberToBeSquared)
        sqInRect(
          newLength,
          newWidth,
          remainingArea - numberToBeSquared * numberToBeSquared,
          acc.appended(numberToBeSquared)
        )
      }
    }

    if (length == width)
      Array.emptyIntArray
    else
      sqInRect(length, width, length * width, Array.emptyIntArray)
  }

}
