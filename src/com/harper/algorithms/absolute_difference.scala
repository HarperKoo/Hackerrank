package com.harper.algorithms

/**
  * Created by harperkoo on 1/15/18.
  * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
  */
object absolute_difference {

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    val nums = scala.io.StdIn.readLine().split(" ").map(_.toInt).sorted.toList
    println(nums.sliding(2).toList.map(e => e(1)-e(0)).min)
  }
}
