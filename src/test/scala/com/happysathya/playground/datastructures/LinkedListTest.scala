package com.happysathya.playground.datastructures

import com.happysathya.playground.ProcessLogs.processLogs
import weaver.FunSuite

object LinkedListTest extends FunSuite:

  test("if item is present in a linked list - Integer") {
    val node1: LinkedListDataNode[Int] = LinkedListDataNode(10)
    val node2: LinkedListDataNode[Int] = LinkedListDataNode(20)
    val node3: LinkedListDataNode[Int] = LinkedListDataNode(30)
    val node4: LinkedListNode[Int]     = LinkedListEmptyNode
    val head: LinkedListNode[Int] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.isPresent(head, 10))
    expect(!LinkedList.isPresent(head, 25))
  }

  test("if item is present in a linked list - String") {
    val node1: LinkedListDataNode[String] = LinkedListDataNode("Ten")
    val node2: LinkedListDataNode[String] = LinkedListDataNode("Twenty")
    val node3: LinkedListDataNode[String] = LinkedListDataNode("Thirty")
    val node4: LinkedListNode[String]     = LinkedListEmptyNode
    val head: LinkedListNode[String] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.isPresent(head, "Ten"))
    expect(!LinkedList.isPresent(head, "Twenty Five"))
  }

  test("fold all items from a linked list - Integer") {
    val node1: LinkedListDataNode[Int] = LinkedListDataNode(10)
    val node2: LinkedListDataNode[Int] = LinkedListDataNode(20)
    val node3: LinkedListDataNode[Int] = LinkedListDataNode(30)
    val node4: LinkedListNode[Int]     = LinkedListEmptyNode
    val head: LinkedListNode[Int] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.fold(head) == List(10, 20, 30))
  }

  test("fold all items from a linked list - String") {
    val node1: LinkedListDataNode[String] = LinkedListDataNode("Ten")
    val node2: LinkedListDataNode[String] = LinkedListDataNode("Twenty")
    val node3: LinkedListDataNode[String] = LinkedListDataNode("Thirty")
    val node4: LinkedListNode[String]     = LinkedListEmptyNode
    val head: LinkedListNode[String] =
      LinkedList.append(node1, LinkedList.append(node2, LinkedList.append(node3, node4)))
    expect(LinkedList.fold(head) == List("Ten", "Twenty", "Thirty"))
  }
end LinkedListTest
