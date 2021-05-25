package com.happysathya.playground

import cats.effect.IO

import scala.collection.mutable

case class Node (data: Int, left: Option[Node] = None, right: Option[Node] = None)

object NodeTraversal {

  def traverseUsingRecursionAndMutableQueue(rootNode: Node): IO[List[Int]] = {
    val queue = new mutable.Queue[Int]()

    def traverse(node: Node): Unit = {
      queue.enqueue(node.data)
      node.left.foreach(n => traverse(n))
      node.right.foreach(n => traverse(n))
    }

    traverse(rootNode)

    IO(queue.dequeueAll(_ => true).toList)
  }

  def breadthFirstTraversal(rootNode: Node): IO[List[Int]] = {
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
}
