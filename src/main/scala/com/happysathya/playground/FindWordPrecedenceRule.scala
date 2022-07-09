package com.happysathya.playground

import scala.annotation.tailrec

object FindWordPrecedenceRule {

  def findWord(rules: List[String]): String = {

    @tailrec
    def findWord(
      rules: List[String],
      ruleMap: Map[Char, Char],
      leastElements: Set[Char]
    ): (Map[Char, Char], Set[Char]) = {
      val pattern = "(.)>(.)".r
      rules match {
        case ::(rule, remainingRules) =>
          rule match {
            case pattern(left, right) =>
              val leftChar   = left.charAt(0)
              val rightChar  = right.charAt(0)
              val leftRight  = Set(leftChar, rightChar)
              val newRuleMap = ruleMap.+(leftChar -> rightChar)
              val updatedLeastElements =
                leastElements.union(leftRight) -- leastElements.intersect(leftRight)
              findWord(remainingRules, newRuleMap, updatedLeastElements)
            case _ => findWord(remainingRules, ruleMap, leastElements)
          }
        case Nil => (ruleMap, leastElements)
      }
    }

    val (ruleMap, leastElements) = findWord(rules, Map.empty, Set.empty)
    val startElementMaybe        = leastElements.find(element => ruleMap.contains(element))

    @tailrec
    def traverseRuleMap(startElement: Char, stringAcc: String): String = {
      ruleMap.get(startElement) match {
        case Some(value) =>
          traverseRuleMap(value, stringAcc + startElement)
        case None => stringAcc + startElement
      }
    }

    startElementMaybe match {
      case Some(startElement) => traverseRuleMap(startElement, "")
      case None               => ""
    }
  }
}
