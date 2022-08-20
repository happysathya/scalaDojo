package com.happysathya.playground

object TapeEquilibrium:

  def tapeEquilibrium(a: Array[Int]): Int =

    def tapeEquilibrium(t: (Long, Long), a: Array[Int], min: Long): Long =
      var newTuple = t
      var newMin   = min
      val iterator = a.iterator
      while iterator.hasNext do
        val head = iterator.next()
        if iterator.hasNext then newTuple = (newTuple._1 + head, newTuple._2 - head)
        newMin = Math.abs(newTuple._1 - newTuple._2) min newMin
      newMin

    val sum        = a.map(_.toLong).sum
    val startTuple = (a.head.toLong, sum - a.head)
    val startMin   = Math.abs(startTuple._1 - startTuple._2)
    tapeEquilibrium(startTuple, a.tail, startMin).toInt
