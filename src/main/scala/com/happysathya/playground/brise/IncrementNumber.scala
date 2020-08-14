package com.happysathya.playground.brise

import cats.effect.IO

import scala.annotation.tailrec

object IncrementNumber {
  
  def increment(seq: Seq[Int]): IO[Seq[Int]] = {

    @tailrec
    def increment(items: Seq[Int], acc: Seq[Int], carry: Int): IO[Seq[Int]] = {
      (items, acc, carry) match {
        case (Nil, Nil, _) => IO(Nil)
        case (Nil, acc, 0) => IO(acc)
        case (Nil, acc, _) => IO(1 +: acc)
        case (head :: tail, acc, carry) =>
          val sum = head + carry
          val (newItem, newCarry) = (sum % 10, sum / 10)
          increment(tail, newItem +: acc, newCarry)
      }
    }

    increment(seq.reverse, Seq.empty, 1)
  }
}

