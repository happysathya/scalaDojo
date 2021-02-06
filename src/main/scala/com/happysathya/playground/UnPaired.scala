package com.happysathya.playground

object UnPaired {

  def unpaired(a: Array[Int]): Int = {
    a.reduceLeft(_ ^ _)
  }
}
