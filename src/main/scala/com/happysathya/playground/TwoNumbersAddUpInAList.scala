package com.happysathya.playground

import cats.effect.IO

import scala.annotation.tailrec

object TwoNumbersAddUpInAList:

  type Hash[T] = java.util.HashSet[T]

  def isTwoNumbersAddUpTo(data: List[Int], sum: Int): IO[Boolean] =

    @tailrec
    def isTwoNumbersAddUpTo(data: List[Int], hashSet: Hash[Int]): IO[Boolean] =
      data.headOption match
        case Some(value) =>
          if hashSet.contains(value) then IO.pure(true)
          else isTwoNumbersAddUpTo(data.tail, { hashSet.add(sum - value); hashSet })
        case None => IO.pure(false)

    isTwoNumbersAddUpTo(data, new Hash[Int]())
