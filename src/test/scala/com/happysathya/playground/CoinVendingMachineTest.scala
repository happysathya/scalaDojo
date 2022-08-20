package com.happysathya.playground

import com.happysathya.playground.CoinVendingMachine.getChange
import org.scalatest.funsuite.AnyFunSuite

class CoinVendingMachineTest extends AnyFunSuite:

  test("test coin vending machine balance denominations") {
    assert(getChange(5, 2) == List("0 * 100", "0 * 50", "0 * 25", "0 * 10", "0 * 5", "3 * 1"))
    assert(getChange(500, 49) == List("4 * 100", "1 * 50", "0 * 25", "0 * 10", "0 * 5", "1 * 1"))
    assert(getChange(100, 7) == List("0 * 100", "1 * 50", "1 * 25", "1 * 10", "1 * 5", "3 * 1"))
  }
