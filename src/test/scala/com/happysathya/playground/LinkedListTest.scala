package com.happysathya.playground

import com.happysathya.playground.ProcessLogs.processLogs
import weaver.FunSuite

object LinkedListTest extends FunSuite:

  test("if item is present in a linked list - Integer") {
    val node1: DataNode[Int]       = DataNode(10)
    val node2: DataNode[Int]       = DataNode(20)
    val node3: DataNode[Int]       = DataNode(30)
    val node4: LinkedListNode[Int] = EmptyNode
    val head: LinkedListNode[Int] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.isPresent(head, 10))
    expect(!LinkedList.isPresent(head, 25))
  }

  test("if item is present in a linked list - String") {
    val node1: DataNode[String]       = DataNode("Ten")
    val node2: DataNode[String]       = DataNode("Twenty")
    val node3: DataNode[String]       = DataNode("Thirty")
    val node4: LinkedListNode[String] = EmptyNode
    val head: LinkedListNode[String] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.isPresent(head, "Ten"))
    expect(!LinkedList.isPresent(head, "Twenty Five"))
  }

  test("fold all items from a linked list - Integer") {
    val node1: DataNode[Int]       = DataNode(10)
    val node2: DataNode[Int]       = DataNode(20)
    val node3: DataNode[Int]       = DataNode(30)
    val node4: LinkedListNode[Int] = EmptyNode
    val head: LinkedListNode[Int] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.fold(head) == List(10, 20, 30))
  }

  test("fold all items from a linked list - String") {
    val node1: DataNode[String]       = DataNode("Ten")
    val node2: DataNode[String]       = DataNode("Twenty")
    val node3: DataNode[String]       = DataNode("Thirty")
    val node4: LinkedListNode[String] = EmptyNode
    val head: LinkedListNode[String] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.fold(head) == List("Ten", "Twenty", "Thirty"))
  }
end LinkedListTest
