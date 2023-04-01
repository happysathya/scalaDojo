package com.happysathya.playground

import scala.annotation.tailrec

sealed trait LinkedListNode[+T]
case object EmptyNode                                                extends LinkedListNode[Nothing]
case class DataNode[T](data: T, next: LinkedListNode[T] = EmptyNode) extends LinkedListNode[T]

object LinkedList:
  def append[T](lastNode: LinkedListNode[T], newNode: LinkedListNode[T]): LinkedListNode[T] =
    lastNode match
      case value @ DataNode(_, _) => value.copy(next = newNode)
      case _                      => lastNode

  @tailrec
  def fold[T](head: LinkedListNode[T], acc: List[T] = List.empty): List[T] =
    head match
      case DataNode(data, next) =>
        fold(next, acc :+ data)
      case _ => acc

  @tailrec
  def isPresent[T](head: LinkedListNode[T], item: T): Boolean =
    head match
      case DataNode(data, next) =>
        if data == item then true
        else isPresent(next, item)
      case _ => false
