package com.happysathya.playground.datastructures

import weaver.FunSuite

object DoublyLinkedListTest extends FunSuite:

  test("if item is present in a doubly linked list - Forward Direction - Integer") {
    val n1: DoublyLinkedListDataNode[Int] = DoublyLinkedListDataNode(10)
    val n2: DoublyLinkedListDataNode[Int] = DoublyLinkedListDataNode(20)
    val n3: DoublyLinkedListDataNode[Int] = DoublyLinkedListDataNode(30)
    val (nodeX, node3)                    = DoublyLinkedList.append(n2, n3)
    val (node1, node2)                    = DoublyLinkedList.append(n1, nodeX)
    expect(DoublyLinkedList.isPresent(node1, 30, Forward))
    expect(DoublyLinkedList.isPresent(node1, 20, Forward))
    expect(DoublyLinkedList.isPresent(node2, 20, Forward))
    expect(DoublyLinkedList.isPresent(node2, 30, Forward))
    expect(!DoublyLinkedList.isPresent(node2, 10, Forward))
    expect(DoublyLinkedList.isPresent(node3, 30, Forward))
    expect(!DoublyLinkedList.isPresent(node3, 40, Forward))
  }

  test("if item is present in a doubly linked list - Backward Direction - String") {
    val n1: DoublyLinkedListDataNode[String] = DoublyLinkedListDataNode("10")
    val n2: DoublyLinkedListDataNode[String] = DoublyLinkedListDataNode("20")
    val n3: DoublyLinkedListDataNode[String] = DoublyLinkedListDataNode("30")
    val (node1, nodeX)                       = DoublyLinkedList.append(n1, n2)
    val (node2, node3)                       = DoublyLinkedList.append(nodeX, n3)
    expect(DoublyLinkedList.isPresent(node3, "30", Backward))
    expect(DoublyLinkedList.isPresent(node3, "20", Backward))
    expect(DoublyLinkedList.isPresent(node3, "10", Backward))
    expect(DoublyLinkedList.isPresent(node2, "20", Backward))
    expect(DoublyLinkedList.isPresent(node2, "10", Backward))
    expect(!DoublyLinkedList.isPresent(node2, "30", Backward))
    expect(!DoublyLinkedList.isPresent(node1, "30", Backward))
  }

  test("fold items in a doubly linked list - Forward Direction - Integer") {
    val n1: DoublyLinkedListDataNode[Int] = DoublyLinkedListDataNode(10)
    val n2: DoublyLinkedListDataNode[Int] = DoublyLinkedListDataNode(20)
    val n3: DoublyLinkedListDataNode[Int] = DoublyLinkedListDataNode(30)
    val (nodeX, node3)                    = DoublyLinkedList.append(n2, n3)
    val (node1, node2)                    = DoublyLinkedList.append(n1, nodeX)
    expect(DoublyLinkedList.fold(node1) == List(10, 20, 30))
    expect(DoublyLinkedList.fold(node2) == List(20, 30))
    expect(DoublyLinkedList.fold(node3) == List(30))
  }

  test("fold items in a doubly linked list - Backward Direction - String") {
    val n1: DoublyLinkedListDataNode[String] = DoublyLinkedListDataNode("10")
    val n2: DoublyLinkedListDataNode[String] = DoublyLinkedListDataNode("20")
    val n3: DoublyLinkedListDataNode[String] = DoublyLinkedListDataNode("30")
    val (node1, nodeX)                       = DoublyLinkedList.append(n1, n2)
    val (node2, node3)                       = DoublyLinkedList.append(nodeX, n3)
    expect(DoublyLinkedList.fold(node3, Backward) == List("30", "20", "10"))
    expect(DoublyLinkedList.fold(node2, Backward) == List("20", "10"))
    expect(DoublyLinkedList.fold(node1, Backward) == List("10"))
  }

end DoublyLinkedListTest
