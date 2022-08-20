package com.happysathya.playground

import cats.effect.IO

import scala.annotation.tailrec

object StringOptimiser:

  def optimise(data: String): IO[List[(Char, Int)]] =

    @tailrec
    def optimise(
        data: Array[Char],
        lastChar: Option[Char] = None,
        length: Int = 0,
        acc: List[(Char, Int)] = List.empty
    ): IO[List[(Char, Int)]] =

      def appendToAccumulator: List[(Char, Int)] =
        lastChar.fold(acc)(lc => acc :+ ((lc, length + 1)))

      data.headOption match
        case Some(value) =>
          if lastChar.contains(value) then
            optimise(data = data.tail, lastChar = Some(value), length = length + 1, acc = acc)
          else optimise(data = data.tail, lastChar = Some(value), acc = appendToAccumulator)
        case None => IO.pure(appendToAccumulator)

    optimise(data.toCharArray)
