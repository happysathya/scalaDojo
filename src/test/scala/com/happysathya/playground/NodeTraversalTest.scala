package com.happysathya.playground

import cats.implicits.catsSyntaxOptionId
import weaver.SimpleIOSuite

object NodeTraversalTest extends SimpleIOSuite {

  simpleTest("traverse tree using recursion and mutable queue") {
    for {
      result1 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(Node(10))
      result2 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(
        Node(10, Node(20).some, Node(30).some)
      )
      result3 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(
        Node(
          10,
          Node(20, Node(40).some, Node(50).some).some,
          Node(30, Node(60).some, Node(70).some).some
        )
      )
      result4 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(
        Node(
          10,
          Node(20, Node(40, Node(80).some, Node(90).some).some, Node(50).some).some,
          Node(30, Node(60).some, Node(70).some).some
        )
      )
    } yield expect.all(
      result1 == List(10),
      result2 == List(10, 20, 30),
      result3 == List(10, 20, 40, 50, 30, 60, 70),
      result4 == List(10, 20, 40, 80, 90, 50, 30, 60, 70),
    )
  }
}
