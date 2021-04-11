package com.happysathya.playground

import cats.implicits.catsSyntaxOptionId
import weaver.SimpleIOSuite

import scala.language.implicitConversions

object NodeTraversalTest extends SimpleIOSuite {

  implicit def _some(node: Node): Option[Node] = node.some

  simpleTest("traverse tree using recursion and mutable queue") {
    for {
      result1 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(Node(10))
      result2 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(
        Node(10, Node(20), Node(30))
      )
      result3 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(
        Node(
          10,
          Node(20, Node(40), Node(50)),
          Node(30, Node(60), Node(70))
        )
      )
      result4 <- NodeTraversal.traverseUsingRecursionAndMutableQueue(
        Node(
          10,
          Node(20, Node(40, Node(80), Node(90)), Node(50)),
          Node(30, Node(60), Node(70))
        )
      )
    } yield expect.all(
      result1 == List(10),
      result2 == List(10, 20, 30),
      result3 == List(10, 20, 40, 50, 30, 60, 70),
      result4 == List(10, 20, 40, 80, 90, 50, 30, 60, 70)
    )
  }
}
