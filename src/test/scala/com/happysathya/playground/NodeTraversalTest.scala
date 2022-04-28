package com.happysathya.playground

import cats.implicits.catsSyntaxOptionId
import weaver.SimpleIOSuite

import scala.language.implicitConversions

object NodeTraversalTest extends SimpleIOSuite {

  implicit def _some(node: Node): Option[Node] = node.some

  test("traverse tree using recursion and mutable queue of a binary tree") {
    for {
      result1 <- NodeTraversal.binaryTreeTraverseUsingRecursionAndMutableQueue(Node(10))
      result2 <- NodeTraversal.binaryTreeTraverseUsingRecursionAndMutableQueue(
        Node(10, Node(20), Node(30))
      )
      result3 <- NodeTraversal.binaryTreeTraverseUsingRecursionAndMutableQueue(
        Node(
          10,
          Node(20, Node(40), Node(50)),
          Node(30, Node(60), Node(70))
        )
      )
      result4 <- NodeTraversal.binaryTreeTraverseUsingRecursionAndMutableQueue(
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

  test("breadth first traversal of a binary tree") {
    for {
      result1 <- NodeTraversal.breadthFirstTraversalBinaryTree(
        Node(
          10,
          Node(20, Node(40, Node(80), Node(90)), Node(50)),
          Node(30, Node(60), Node(70))
        )
      )
      result2 <- NodeTraversal.breadthFirstTraversalBinaryTree(
        Node(10)
      )
    } yield expect.all(
      result1 == List(10, 20, 30, 40, 50, 60, 70, 80, 90),
      result2 == List(10)
    )
  }

  test("depth first traversal of a binary tree") {
    for {
      result1 <- NodeTraversal.depthFirstSearchBinaryTree(
        Node(
          1,
          Node(2, Node(3, Node(4), Node(5)), Node(6)),
          Node(8, Node(9, Node(10), Node(11)), Node(12))
        )
      )
      result2 <- NodeTraversal.depthFirstSearchBinaryTree(
        Node(10)
      )
      result3 <- NodeTraversal.depthFirstSearchBinaryTree(
        Node(
          1,
          Node(2, Node(3, Node(4), Node(5)), Node(6)),
          Node(8, Node(9, Node(10), Node(1)), Node(2))
        )
      )
      result4 <- NodeTraversal.depthFirstSearchBinaryTree(
        Node(
          1,
          Node(2, Node(3, Node(4, Node(5, Node(6), Node(7)))), Node(10)),
          Node(9)
        )
      )
      result5 <- NodeTraversal.depthFirstSearchBinaryTree(
        Node(
          6,
          Node(2, Node(1), Node(4, Node(3), Node(5))),
          Node(7, None, Node(9, Node(8)))
        )
      )
    } yield expect.all(
      result1 == List(1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12),
      result2 == List(10),
      result3 == List(1, 2, 3, 4, 5, 6, 8, 9, 10, 1, 2),
      result4 == List(1, 2, 3, 4, 5, 6, 7, 10, 9),
      result5 == List(6, 2, 1, 4, 3, 5, 7, 9, 8)
    )
  }

}
