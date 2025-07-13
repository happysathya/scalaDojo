package com.happysathya.playground.algorithms

object BinaryGap:

  def binaryGap(n: Int): Int =

    def numberToBinaryString(n: Int): String =
      def numberToBinaryString(n: Int, acc: String = ""): String =
        if n == 0 then acc
        else numberToBinaryString(n / 2, s"${n % 2}$acc")

      if n == 0 then "0" else numberToBinaryString(n)

    def binaryGap(binaryString: Array[Char], prevMaxLength: Int, currentLength: Int): Int =
      binaryString.headOption match
        case None      => prevMaxLength
        case Some('1') => binaryGap(binaryString.tail, currentLength max prevMaxLength, 0)
        case Some(_)   => binaryGap(binaryString.tail, prevMaxLength, currentLength + 1)

    binaryGap(numberToBinaryString(n).toCharArray, 0, 0)
