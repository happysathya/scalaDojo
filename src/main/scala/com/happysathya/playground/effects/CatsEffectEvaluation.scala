package com.happysathya.playground.effects

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits.*

object CatsEffectEvaluation extends IOApp:

  override def run(args: List[String]): IO[ExitCode] =
    for
      _ <- startComputation("Requirement 1")
      _ <- task2DependentOnTask1AndTask4DependentOnTask3
      _ <- endComputation

      _ <- startComputation("Requirement 2")
      _ <- task3DependentOnTask2AndNotDependentOnTask1AndTask4
      _ <- endComputation

      _ <- startComputation("Requirement 3")
      _ <- tasksIndependentOfEachOther
      _ <- endComputation
    yield ExitCode.Success

  def task3DependentOnTask2AndNotDependentOnTask1AndTask4: IO[Unit] =

    def task3DependentOnTask2: IO[Unit] =
      for
        _ <- task2
        _ <- task3
      yield ()

    for _ <- (task3DependentOnTask2, task1, task4).parTupled
    yield ()

  def task2DependentOnTask1AndTask4DependentOnTask3: IO[Unit] =

    def task2DependentOnTask1: IO[Unit] =
      for
        _ <- task1
        _ <- task2
      yield ()

    def task4DependentOnTask3: IO[Unit] =
      for
        _ <- task3
        _ <- task4
      yield ()

    for _ <- (task2DependentOnTask1, task4DependentOnTask3).parTupled
    yield ()

  def tasksIndependentOfEachOther: IO[Unit] =
    for _ <- (task1, task2, task3, task4).parTupled
    yield ()

  def task1: IO[Unit] = IO {
    println("i am task1")
  }

  def task2: IO[Unit] = IO {
    println("i am task2")
  }

  def task3: IO[Unit] = IO {
    println("i am task3")
  }

  def task4: IO[Unit] = IO {
    println("i am task4")
  }

  def endComputation: IO[Unit] = IO {
    println("end computation")
    println("")
  }

  def startComputation(requirement: String): IO[Unit] = IO {
    println(s"start computation - $requirement")
  }
end CatsEffectEvaluation
