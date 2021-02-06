package com.happysathya.playground

object CountBits {

  def countBits(n: Int): Int = {

    def countBits(n: Int, acc: String): String = {
      if (n == 0)
        return acc
      else
        countBits(n / 2, (n % 2) + acc)
    }

    countBits(n, "").toList.count(c => c == '1')
  }

}
