package com.happysathya.playground

import cats.Monad
import cats.implicits._

object GcdAndLcmEuclidean {

  /*
    (a, b) by (b, a mod b) repeatedly until the pair is (d, 0), where d is the greatest common divisor.
   */
  def greatestCommonDivisor[F[_]](a: Int, b: Int)(implicit
    F: Monad[F]
  ): F[Int] = {
    F.ifM(F.pure(b == 0))(F.pure(a), greatestCommonDivisor[F](b, a % b))
  }

  /*
    lcm(a, b) = (a * b) / gcd(a, b)
   */
  def leastCommonMultiple[F[_]](a: Int, b: Int)(implicit
    F: Monad[F]
  ): F[Int] = {
    for {
      gcd    <- greatestCommonDivisor[F](a, b)
      result <- F.pure((a * b) / gcd)
    } yield result
  }
}
