package com.happysathya.playground.cats

import java.time.{Clock, Instant, ZoneId}

import cats.effect.{IO, Resource}
import weaver.IOSuite

object ScalaTimeImplTest extends IOSuite {

  override type Res = Clock

  test("Scala time test") { clock =>
    val value = new ScalaTimeImpl[IO](clock)
    for {
      a <- value.getInstant
    } yield expect(a == Instant.now(clock))
  }

  override def sharedResource: Resource[IO, Clock] = {
    Resource.make {
      IO.pure(Instant.ofEpochSecond(1600894047))
        .map(i => Clock.fixed(i, ZoneId.systemDefault()))
    }(_ => IO.unit)
  }
}
