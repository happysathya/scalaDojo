package com.happysathya.playground

import scala.annotation.tailrec

object CoinVendingMachine {

  def getChange(moneyInserted: Int, priceOfItem: Int): List[String] = {
    val changeToBeGiven = moneyInserted - priceOfItem

    @tailrec
    def getChange(
      remainingChangeToBeGiven: Int,
      coinChanges: List[String],
      denominations: List[Int]
    ): List[String] = {
      if (denominations.isEmpty)
        coinChanges
      else {
        val denomination      = denominations.head
        val denominationTimes = remainingChangeToBeGiven / denomination
        val formattedResult   = s"$denominationTimes * $denomination"
        val remainingChange   = remainingChangeToBeGiven % denomination
        getChange(remainingChange, coinChanges :+ formattedResult, denominations.tail)
      }

    }
    getChange(changeToBeGiven, List.empty, List(100, 50, 25, 10, 5, 1))
  }
}
