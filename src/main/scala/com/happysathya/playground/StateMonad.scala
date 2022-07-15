package com.happysathya.playground

import cats.data.{IndexedStateT, State, StateT}
import cats.effect.{unsafe, IO}

import scala.util.Random

object StateMonad {

  private val randomT: StateT[IO, List[Int], Int] = StateT { previousState =>
    {
      val random = Random.between(0, 10)
      IO.pure((previousState :+ random, random))
    }
  }

  private val random: State[List[Int], Int] = State { previousState =>
    {
      val random = Random.between(0, 10)
      (previousState :+ random, random)
    }
  }

  def someRandomT(): IO[List[Int]] = {
    val result: IndexedStateT[IO, List[Int], List[Int], Unit] = for {
      _ <- randomT
      _ <- randomT
      _ <- randomT
    } yield ()
    result.runEmpty.map(_._1)
  }

  def someRandom(): List[Int] = {
    val result = for {
      _ <- random
      _ <- random
      _ <- random
    } yield ()
    result.runEmpty.value._1
  }

}

object AppMain extends App {
  private val value1: List[Int] = StateMonad.someRandom()
  private val value2: List[Int] = StateMonad.someRandom()
  println(value1)
  println(value2)
  val runtime                   = cats.effect.unsafe.IORuntime.global
  private val valueT: List[Int] = StateMonad.someRandomT().unsafeRunSync()(runtime)
  println(valueT)
}
