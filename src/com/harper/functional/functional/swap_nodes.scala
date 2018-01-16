package com.harper.functional.functional

/**
  * Created by harperkoo on 7/27/17.
  * https://www.hackerrank.com/challenges/swap-nodes
  */

import java.util.Scanner

object swap_nodes extends App {

  object Node {
    def emptyNode(value: Int, depth: Int): Node = {
      new Node(value, None, None, depth)
    }

    def buildNode(v: Int, d: Int): Option[Node] = {
      if (v == -1) {
        None
      } else {
        Some(emptyNode(v, d))
      }
    }
  }

  class Node(value: Int, left: Option[Node], right: Option[Node], depth: Int) {
    var swapped = true
    def swap(d: Int) {
      if (depth % d == 0) {
        swapped = !swapped
      }
      left map { l =>
        l.swap(d)
      }
      right map { r =>
        r.swap(d)
      }
    }

    def apply(v: Int, p: (Int, Int)): Node = {
      if (v == value) {
        new Node(value, Node.buildNode(p._1, depth+1), Node.buildNode(p._2, depth+1), depth)
      } else {
        val newLeft = left map { l =>
          l.apply(v, p)
        }
        val newRight = right map { r =>
          r.apply(v, p)
        }
        new Node(value, newLeft, newRight, depth)
      }
    }

    def traverse(): String = {
      val leftT = left match {
        case Some(n) => n.traverse()
        case None => ""
      }
      val rightT = right match {
        case Some(n) => n.traverse()
        case None => ""
      }
      if (swapped) {
        (leftT + " " + value + " " + rightT).trim
      } else {
        (rightT + " " + value + " " + leftT).trim
      }
    }
  }

  val in = new Scanner(System.in)
  val N = in.nextInt()
  val rootNode = (1 to N).foldLeft(Node.emptyNode(1, 1))((node, idx) => {
    val a,b = in.nextInt()
    val pair = (a,b)
    node.apply(idx, pair)
  })
  val K = in.nextInt()
  (0 until K).foldLeft(rootNode)((node, _) => {
    val idx = in.nextInt()
    node.swap(idx)
    println(node.traverse())
    node
  })
}
