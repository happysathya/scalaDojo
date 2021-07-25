package com.happysathya.playground

import cats.effect.IO

import scala.annotation.tailrec

object FibonacciSum {

  def fibonacciSumUsingRecursion(n: Int): IO[Long] = {
    n match {
      case 0          => IO.pure(0)
      case 1          => IO.pure(1)
      case _ if n < 0 => IO.raiseError(new RuntimeException(s"n cannot be negative"))
      case _ =>
        for {
          r1 <- fibonacciSumUsingRecursion(n - 1)
          r2 <- fibonacciSumUsingRecursion(n - 2)
        } yield r1 + r2
    }
  }

  def fibonacciSumUsingIterative(n: Int): IO[Long] = {
    var previous, sum = 0L
    for {
      _ <- IO.raiseWhen(n < 0)(new RuntimeException(s"n cannot be negative"))
      _ <- {
        for (i <- 0.to(n)) {
          val (p: Long, s: Long) = i match {
            case 0 | 1 => (previous, sum + i)
            case _     => (sum, sum + previous)
          }
          previous = p; sum = s
        }
        IO.pure(sum)
      }
    } yield sum
  }

  def fibonacciSumUsingTailRecursion(n: Int): IO[Long] = {

    @tailrec
    def fibonacci(index: Int = 0, prev: Long = 1, acc: Long = 0): IO[Long] = {
      index match {
        case 0               => fibonacci(index + 1)
        case _ if index <= n => fibonacci(index + 1, acc, acc + prev)
        case _               => IO.pure(acc)
      }
    }

    if (n < 0) IO.raiseError(new RuntimeException(s"n cannot be negative"))
    else
      fibonacci()
  }
}
