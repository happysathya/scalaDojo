package com.happysathya.playground.datastructures

import scala.annotation.tailrec

sealed trait DoublyLinkedListNode[+T]
case object DoublyLinkedListEmptyNode extends DoublyLinkedListNode[Nothing]
case class DoublyLinkedListDataNode[T](
    data: T,
    next: DoublyLinkedListNode[T] = DoublyLinkedListEmptyNode,
    prev: DoublyLinkedListNode[T] = DoublyLinkedListEmptyNode
) extends DoublyLinkedListNode[T]

sealed trait SearchDirection
case object Forward  extends SearchDirection
case object Backward extends SearchDirection

object DoublyLinkedList:
  def append[T](
      lastNode: DoublyLinkedListDataNode[T],
      newNode: DoublyLinkedListDataNode[T]
  ): (DoublyLinkedListDataNode[T], DoublyLinkedListDataNode[T]) =
    (lastNode.copy(next = newNode), newNode.copy(prev = lastNode))

  @tailrec
  def fold[T](
      head: DoublyLinkedListNode[T],
      searchDirection: SearchDirection = Forward,
      acc: List[T] = List.empty
  ): List[T] =
    head match
      case DoublyLinkedListDataNode(data, next, prev) =>
        searchDirection match
          case Forward  => fold(next, searchDirection, acc :+ data)
          case Backward => fold(prev, searchDirection, acc :+ data)
      case _ => acc

  @tailrec
  def isPresent[T](
      anyNode: DoublyLinkedListNode[T],
      item: T,
      searchDirection: SearchDirection
  ): Boolean =
    anyNode match
      case DoublyLinkedListEmptyNode => false
      case DoublyLinkedListDataNode(data, next, prev) =>
        if data == item then true
        else
          searchDirection match
            case Forward  => isPresent(next, item, searchDirection)
            case Backward => isPresent(prev, item, searchDirection)
end DoublyLinkedList
