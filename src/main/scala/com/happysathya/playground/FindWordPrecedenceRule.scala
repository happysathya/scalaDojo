package com.happysathya.playground

import scala.annotation.tailrec

object FindWordPrecedenceRule:

  def findWord(rules: List[String]): String =

    @tailrec
    def findWord(
        rules: List[String],
        ruleMap: Map[String, String],
        leastElements: Set[String]
    ): (Map[String, String], Set[String]) =
      val pattern = "(.)>(.)".r
      rules match
        case ::(rule, remainingRules) =>
          rule match
            case pattern(left, right) =>
              val leftRight  = Set(left, right)
              val newRuleMap = ruleMap.+(left -> right)
              val updatedLeastElements =
                leastElements.union(leftRight) -- leastElements.intersect(leftRight)
              findWord(remainingRules, newRuleMap, updatedLeastElements)
            case _ => findWord(remainingRules, ruleMap, leastElements)
        case Nil => (ruleMap, leastElements)

    val (ruleMap, leastElements) = findWord(rules, Map.empty, Set.empty)
    val startElementMaybe        = leastElements.find(element => ruleMap.contains(element))

    @tailrec
    def traverseRuleMap(startElement: String, stringAcc: String): String =
      ruleMap.get(startElement) match
        case Some(value) =>
          traverseRuleMap(value, stringAcc + startElement)
        case None => stringAcc + startElement

    startElementMaybe match
      case Some(startElement) => traverseRuleMap(startElement, "")
      case None               => ""
  end findWord
end FindWordPrecedenceRule
