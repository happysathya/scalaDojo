package com.happysathya.playground

import com.happysathya.playground.CodeWars.{countBits, order, persistence, sqInRect}
import com.happysathya.playground.Codility._
import com.happysathya.playground.DataStructureDecisionForJava.decision
import com.happysathya.playground.FirstUniqueCharacter.findFirstUniqueCharacter
import org.scalatest.FunSuite

class TestPlayground extends FunSuite {

  test("findFirstUniqueCharacter") {
    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABBAEHF")
      assert(result.isRight)
      assert(result.right.get == 'E')
    }

    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABC")
      assert(result.isRight)
      assert(result.right.get == 'A')
    }

    {
      val result: Either[String, Char] = findFirstUniqueCharacter("ABBA")
      assert(result.isLeft)
      assert(result.left.get == "No unique characters")
    }
  }

  test("LowestNumberInConstantTime") {
    {
      val lowestNumberInConstantTime = new LowestNumberInConstantTime()

      lowestNumberInConstantTime.push(5)

      assert(lowestNumberInConstantTime.lowestValue().get == 5)

      lowestNumberInConstantTime.push(1)
      lowestNumberInConstantTime.push(2)

      assert(lowestNumberInConstantTime.lowestValue().get == 1)

      lowestNumberInConstantTime.push(0)

      assert(lowestNumberInConstantTime.lowestValue().get == 0)

      lowestNumberInConstantTime.pop()
      assert(lowestNumberInConstantTime.lowestValue().get == 1)
    }

    {
      val lowestNumberInConstantTime = new LowestNumberInConstantTime()

      lowestNumberInConstantTime.pushAll(List(3, 1, 2, 5, 3, 2))

      assert(lowestNumberInConstantTime.lowestValue().get == 1)
    }
  }

  test("ListCalculator") {
    {
      val sum = ListCalculator.sum(List.empty)
      assert(sum == 0)
    }

    {
      val sum = ListCalculator.sum(List(1, 3, 5))
      assert(sum == 9)
    }

    {
      val product = ListCalculator.product(List.empty)
      assert(product == 1)
    }

    {
      val product = ListCalculator.product(List(1, 3, 5))
      assert(product == 15)
    }

    {
      val division = ListCalculator.divide(List.empty)
      assert(division == 0)
    }

    {
      val division = ListCalculator.divide(List(5))
      assert(division == 5)
    }

    {
      val division = ListCalculator.divide(List(1, 3, 5))
      assert(division == 0.06666666666666667)
    }
  }

  test("DataStructureDecisionForJava") {
    assert(decision(Problem(KeyValuePair, AnyOrdering)) == HashMap)
    assert(decision(Problem(KeyValuePair, SortedOrdering)) == TreeMap)
    assert(decision(Problem(KeyValuePair, InsertionOrdering)) == LinkedHashMap)

    assert(decision(Problem(ValuesWithDuplicates, AnyOrdering)) == ArrayList)

    assert(decision(Problem(ValuesWithoutDuplicates, AnyOrdering, AnyTask)) == ArrayList)
    assert(decision(Problem(ValuesWithoutDuplicates, AnyOrdering, SearchAndRemove)) == HashSet)
    assert(decision(Problem(ValuesWithoutDuplicates, InsertionOrdering, SearchAndRemove)) == LinkedHashSet)
    assert(decision(Problem(ValuesWithoutDuplicates, SortedOrdering, SearchAndRemove)) == TreeSet)

  }

  test("code wars") {
    {
      assert(countBits(5) == 2)
      assert(countBits(4) == 1)
    }
    {
      assert(sqInRect(5, 3) sameElements Array(3, 2, 1, 1))
      assert(sqInRect(4, 4).isEmpty)
      assert(sqInRect(4, 5) sameElements Array(4, 1, 1, 1, 1))
      assert(sqInRect(20, 14) sameElements Array(14, 6, 6, 2, 2, 2))
    }
    {
      assert(persistence(397) == 4)
      assert(persistence(4) == 0)
      assert(persistence(999) == 4)
      assert(persistence(39) == 3)
    }
    {
      assert(order("is2 Thi1s T4est 3a") == "Thi1s is2 3a T4est")
      assert(order("") == "")
    }
  }

  test("codility") {
    {
      assert(binaryGap(0) == 0)
      assert(binaryGap(3) == 0)
      assert(binaryGap(1041) == 5)
      assert(binaryGap(529) == 4)
      assert(binaryGap(15) == 0)
    }
    {
      assert(rightShiftByNTimes(Array(3, 8, 9, 7, 6), 3) sameElements Array(9, 7, 6, 3, 8))
      assert(rightShiftByNTimes(Array(1), 2) sameElements Array(1))
      assert(rightShiftByNTimes(Array[Int](), 5) sameElements Array[Int]())
    }
    {
      assert(unpaired(Array(3, 9, 4, 9, 3)) == 4)
    }
    {
      assert(frogJump(10, 85, 30) == 3)
      assert(frogJump(10, 100, 30) == 3)
    }
    {
      assert(missingElement(Array(2, 3, 1, 5)) == 4)
      assert(missingElement(Array()) == 1)
      assert(missingElement(Array(1)) == 2)
    }
    {
      assert(tapeEquilibrium(Array(3, 1, 2, 4, 3)) == 1)
      assert(tapeEquilibrium(Array(1, 3)) == 2)
      assert(tapeEquilibrium(Array(3, 1)) == 2)
      assert(tapeEquilibrium(Array(0, 1)) == 1)
      assert(tapeEquilibrium(Array(1, 0)) == 1)
      assert(tapeEquilibrium(Array(-1, 2)) == 3)
      assert(tapeEquilibrium(Array(-3, -2, -1)) == 0)
      assert(tapeEquilibrium(Array(-1, -2, 5)) == 4)
    }
  }
}
