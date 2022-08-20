package com.happysathya.playground

sealed trait Data
case object ValuesWithDuplicates    extends Data
case object ValuesWithoutDuplicates extends Data
case object KeyValuePair            extends Data

sealed trait Order
case object InsertionOrdering extends Order
case object SortedOrdering    extends Order
case object AnyOrdering       extends Order

sealed trait Task
case object AnyTask         extends Task
case object SearchAndRemove extends Task

sealed trait Decision
case object TreeMap       extends Decision
case object LinkedHashMap extends Decision
case object HashMap       extends Decision
case object ArrayList     extends Decision
case object LinkedHashSet extends Decision
case object TreeSet       extends Decision
case object HashSet       extends Decision

case class Problem(data: Data, order: Order, task: Task = AnyTask)

object DataStructureDecisionForJava:

  def decision(problem: Problem): Decision =
    problem match
      case Problem(KeyValuePair, order, _) =>
        order match
          case InsertionOrdering => LinkedHashMap
          case SortedOrdering    => TreeMap
          case AnyOrdering       => HashMap
      case Problem(ValuesWithoutDuplicates, order, task) =>
        (order, task) match
          case (_, AnyTask) => ArrayList
          case (order, SearchAndRemove) =>
            order match
              case InsertionOrdering => LinkedHashSet
              case SortedOrdering    => TreeSet
              case AnyOrdering       => HashSet
      case Problem(ValuesWithDuplicates, _, _) => ArrayList
