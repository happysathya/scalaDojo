package com.happysathya.playground

object Codility {

  def binaryGap(n: Int): Int = {

    def numberToBinaryString(n: Int): String = {
      def numberToBinaryString(n: Int, acc: String = ""): String = {
        if (n == 0)
          acc
        else
          numberToBinaryString(n / 2, s"${n % 2}$acc")
      }

      if (n == 0) "0" else numberToBinaryString(n)
    }

    def binaryGap(binaryString: Array[Char], prevMaxLength: Int, currentLength: Int): Int = {
      binaryString.headOption match {
        case None => prevMaxLength
        case Some('1') => binaryGap(binaryString.tail, currentLength max prevMaxLength, 0)
        case Some(_) => binaryGap(binaryString.tail, prevMaxLength, currentLength + 1)
      }
    }

    binaryGap(numberToBinaryString(n).toCharArray, 0, 0)
  }

  def rightShiftByNTimes(array: Array[Int], k: Int): Array[Int] = {
    if (k == 0)
      array
    else array match {
      case a if a.isEmpty || a.tail.isEmpty => a
      case a =>
        val b = a.reverse
        rightShiftByNTimes(b.head +: b.tail.reverse, k - 1)
    }
  }

  def unpaired(a: Array[Int]): Int = {
    a.reduceLeft(_ ^ _)
  }

  def frogJump(x: Int, y: Int, d: Int): Int = {
    (y - x) / d + (if ((y - x) % d == 0)
      0
    else
      1)
  }

  def missingElement(a: Array[Int]): Int = {
    Math.subtractExact((a.length + 1L) * (a.length + 2L) / 2L, a.map(_.toLong).sum).toInt
  }

  def tapeEquilibrium(a: Array[Int]): Int = {

    def tapeEquilibrium(t: (Long, Long), a: Array[Int], min: Long): Long = {
      var newTuple = t
      var newMin = min
      val iterator = a.iterator
      while (iterator.hasNext) {
        val head = iterator.next()
        if (iterator.hasNext)
          newTuple = (newTuple._1 + head, newTuple._2 - head)
        newMin = Math.abs(newTuple._1 - newTuple._2) min newMin
      }
      newMin
    }

    val sum = a.map(_.toLong).sum
    val startTuple = (a.head.toLong, sum - a.head)
    val startMin = Math.abs(startTuple._1 - startTuple._2)
    tapeEquilibrium(startTuple, a.tail, startMin).toInt
  }

  def smallestPositiveInteger(a: Array[Int]): Int = {
    (Range(1, a.length + 2).toSet diff a.toSet).min
  }

}
