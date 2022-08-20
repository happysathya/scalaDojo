package com.happysathya.playground

import scala.annotation.tailrec

object IterablePairWithNextElement:

  def pairWithNextElement[T](a: Iterable[T]): Iterable[(T, T)] =

    @tailrec
    def pairWithNextElement(innerA: Iterable[T], acc: Iterable[(T, T)]): Iterable[(T, T)] =
      innerA match
        case head :: tail if tail.nonEmpty =>
          pairWithNextElement(tail, acc ++ Iterable((head, tail.head)))
        case _ => acc

    pairWithNextElement(a, Iterable.empty)
