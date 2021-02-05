package com.happysathya.playground.brise

import cats.effect.{Effect, ExitCode, IO, IOApp}

class myClass[F[_]: Effect] {

  val effect = implicitly[Effect[F]]

  def op1: F[Unit] = {
    effect.delay(println("op1"))
  }

  def op2: F[Int] = {
    effect.delay(42)
  }
}

object EffectTypeClass extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    val ioClass = new myClass[IO]
    val computation = for {
      _    <- ioClass.op1
      data <- ioClass.op2
      _    <- IO.delay(println(data))
    } yield ()
    computation.as(ExitCode.Success)
  }
}
