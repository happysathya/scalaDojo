package com.happysathya.playground

import scala.annotation.tailrec

object RecursiveDigitSum {

  def superDigit(number: String, times: Int): Int = {

    val updatedNumberInString = number.repeat(times)
    val initialSum            = updatedNumberInString.foldLeft(0)((sum: Int, c: Char) => sum + c.asDigit)

    @tailrec
    def superDigit(updatedSum: Int, acc: Int): Int = {
      if (updatedSum == 0) {
        if (acc / 10 == 0) return acc
        superDigit(acc, 0)
      } else superDigit(updatedSum / 10, acc + updatedSum % 10)
    }

    superDigit(initialSum, 0)
  }
}
