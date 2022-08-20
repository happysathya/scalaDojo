package com.happysathya.playground

object FrogJump:

  def frogJump(x: Int, y: Int, d: Int): Int =
    (y - x) / d + (if (y - x) % d == 0 then 0
                   else 1)
