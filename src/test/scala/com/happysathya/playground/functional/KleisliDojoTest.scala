package com.happysathya.playground.functional

import cats.data.Kleisli
import cats.effect.IO
import weaver.SimpleIOSuite

object KleisliDojoTest extends SimpleIOSuite {

  test("using kleisli to compose functions") {
    for {
      input <- IO.pure(10)
      doubleKleisli   = Kleisli[IO, Int, Int]((a: Int) => IO.pure(a * a))
      toStringKleisli = Kleisli[IO, Int, String]((a: Int) => IO.pure(s"$a"))
      result <- KleisliDojo.andThenRun(doubleKleisli, toStringKleisli, input)
    } yield expect(result == "100")
  }
}
