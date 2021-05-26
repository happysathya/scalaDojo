package com.happysathya.playground

import cats.effect.IO

import java.util
import java.util.UUID
import scala.collection.mutable
import scala.jdk.CollectionConverters.CollectionHasAsScala

case class Node (data: Int, left: Option[Node], right: Option[Node], key: UUID)

object Node {
  def apply(data: Int, left: Option[Node] = None, right: Option[Node] = None): Node = {
    Node(data, left, right, key = UUID.randomUUID())
  }
}

object NodeTraversal {

  def binaryTreeTraverseUsingRecursionAndMutableQueue(rootNode: Node): IO[List[Int]] = {
    val queue = new mutable.Queue[Int]()

    def traverse(node: Node): Unit = {
      queue.enqueue(node.data)
      node.left.foreach(n => traverse(n))
      node.right.foreach(n => traverse(n))
    }

    traverse(rootNode)

    IO(queue.dequeueAll(_ => true).toList)
  }

  def breadthFirstTraversalBinaryTree(rootNode: Node): IO[List[Int]] = {
    val dataQueue = new mutable.Queue[Int]()
    val traversalQueue = new mutable.Queue[Node]()
    traversalQueue.enqueue(rootNode)

    while(traversalQueue.nonEmpty) {
      val nodeAtTop = traversalQueue.dequeue()
      dataQueue.enqueue(nodeAtTop.data)
      nodeAtTop.left.foreach(node => traversalQueue.enqueue(node))
      nodeAtTop.right.foreach(node => traversalQueue.enqueue(node))
    }

    IO(dataQueue.dequeueAll(_ => true).toList)
  }

  def depthFirstSearchBinaryTree(rootNode: Node): IO[List[Int]] = {
    val dataStack = new mutable.Stack[Node]()
    val visited = new util.LinkedHashMap[UUID, Int]()

    dataStack.push(rootNode)
    while (dataStack.nonEmpty) {
      visited.put(dataStack.top.key, dataStack.top.data)
      dataStack.top.left match {
        case Some(value) if !visited.containsKey(value.key) => dataStack.push(value)
        case _ =>
          val poppedNode = dataStack.pop()
          poppedNode.right match {
            case Some(value) if !visited.containsKey(value.key) => dataStack.push(value)
            case _ => ()
          }
      }
    }

    IO(visited.values().asScala.toList)
  }
}
