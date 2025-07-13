package com.happysathya.playground.functional

import cats.data.Kleisli
import cats.effect.IO

object KleisliDojo {
  def andThenRun(
      k1: Kleisli[IO, Int, Int],
      k2: Kleisli[IO, Int, String],
      input: Int
  ): IO[String] = {
    val result = k1 andThen k2
    result.run(input)
  }
}
