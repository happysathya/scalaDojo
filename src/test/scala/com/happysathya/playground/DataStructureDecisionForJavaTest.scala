package com.happysathya.playground

import com.happysathya.playground.DataStructureDecisionForJava.decision
import org.scalatest.funsuite.AnyFunSuite

class DataStructureDecisionForJavaTest extends AnyFunSuite:

  test("DataStructureDecisionForJava") {
    assert(decision(Problem(KeyValuePair, AnyOrdering)) == HashMap)
    assert(decision(Problem(KeyValuePair, SortedOrdering)) == TreeMap)
    assert(decision(Problem(KeyValuePair, InsertionOrdering)) == LinkedHashMap)

    assert(decision(Problem(ValuesWithDuplicates, AnyOrdering)) == ArrayList)

    assert(decision(Problem(ValuesWithoutDuplicates, AnyOrdering, AnyTask)) == ArrayList)
    assert(decision(Problem(ValuesWithoutDuplicates, AnyOrdering, SearchAndRemove)) == HashSet)
    assert(
      decision(
        Problem(ValuesWithoutDuplicates, InsertionOrdering, SearchAndRemove)
      ) == LinkedHashSet
    )
    assert(decision(Problem(ValuesWithoutDuplicates, SortedOrdering, SearchAndRemove)) == TreeSet)

  }
