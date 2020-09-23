package com.happysathya.playground.cats

import java.time.{Clock, Instant}

import cats.effect.Sync

trait ScalaTime[F[_]] {
  def getInstant: F[Instant]
}

class ScalaTimeImpl[F[_]](clock: Clock)(implicit F: Sync[F]) extends ScalaTime[F] {
  override def getInstant: F[Instant] = {
    F.recoverWith(F.delay(Instant.now(clock))) {
      case _ => F.delay(Instant.now())
    }
  }
}