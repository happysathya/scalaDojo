package com.happysathya.playground.effects

import cats.effect.IO

import scala.annotation.tailrec

object IncrementNumber:

  def increment(seq: Seq[Int]): IO[Seq[Int]] =

    @tailrec
    def increment(items: Seq[Int], acc: Seq[Int], carry: Int): IO[Seq[Int]] =
      (items, acc, carry) match
        case (Nil, Nil, carry) if carry == 1 => IO(Nil)
        case (Nil, acc, carry)               => if carry == 0 then IO(acc) else IO(1 +: acc)
        case (head :: tail, acc, carry) =>
          val sum                 = head + carry
          val (newItem, newCarry) = (sum % 10, sum / 10)
          increment(tail, newItem +: acc, newCarry)
        case _ => IO(acc) // This should never happen, but included for exhaustiveness

    increment(seq.reverse, Seq.empty, 1)
