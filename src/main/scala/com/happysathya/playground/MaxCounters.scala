package com.happysathya.playground

import cats.effect.IO

import scala.annotation.tailrec

object MaxCounters {

  def maxCounters(n: Int, a: Array[Int]): IO[Array[Int]] = {

    @tailrec
    def maxCounters(inputData: Array[Int], prevMax: Int, resultData: Array[Int]): IO[Array[Int]] = {
      inputData.headOption match {
        case Some(value) =>
          if (value > n) maxCounters(inputData.tail, prevMax, Array.fill(n)(prevMax))
          else {
            resultData(value - 1) += 1
            maxCounters(inputData.tail, prevMax max resultData(value - 1), resultData)
          }
        case None => IO.pure(resultData)
      }
    }

    maxCounters(inputData = a, prevMax = 0, resultData = Array.fill(n)(0))
  }
}
