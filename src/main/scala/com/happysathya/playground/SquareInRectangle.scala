package com.happysathya.playground

import scala.annotation.tailrec

object SquareInRectangle:

  def sqInRect(length: Int, width: Int): Array[Int] =

    def min(length: Int, width: Int): Int =
      if length < width then length else width

    @tailrec
    def sqInRect(length: Int, width: Int, remainingArea: Int, acc: Array[Int]): Array[Int] =
      if remainingArea == 0 then acc
      else
        val numberToBeSquared = min(length, width)
        val (newLength: Int, newWidth: Int) =
          if length > width then (length - numberToBeSquared, width)
          else (length, width - numberToBeSquared)
        sqInRect(
          newLength,
          newWidth,
          remainingArea - numberToBeSquared * numberToBeSquared,
          acc.appended(numberToBeSquared)
        )

    if length == width then Array.emptyIntArray
    else sqInRect(length, width, length * width, Array.emptyIntArray)
