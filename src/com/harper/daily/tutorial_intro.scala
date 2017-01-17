package com.harper.daily

/**
  * Created by harperkoo on 1/16/17.
  */
object tutorial_intro {
  def main(args: Array[String]): Unit = {
    val V = scala.io.StdIn.readInt
    val n = scala.io.StdIn.readInt
    val ar = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
//    println(V,n,ar)
    println(ar.indexOf(V))
  }
}
