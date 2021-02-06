package com.happysathya.playground

object IsSorted {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    as.foldLeft((true, Option.empty[A]))((lastResult, value) => {
      lastResult match {
        case (true, None)       => (true, Some(value))
        case (false, _)         => (false, Some(value))
        case (true, Some(data)) => (ordered(data, value), Some(value))
      }
    })._1
  }

}
