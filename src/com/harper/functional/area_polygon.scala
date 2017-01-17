package com.harper.functional

/**
  * Created by harperkoo on 1/16/17.
  * https://www.hackerrank.com/challenges/lambda-march-compute-the-area-of-a-polygon
  */
object area_polygon {
  def main(args: Array[String]) {
    val N = scala.io.StdIn.readInt
    val points = (1 to N).map(_ => scala.io.StdIn.readLine()).toList
    println(if(N>2) dist(points:+points.head) else "0")
  }

  def getLeft(A: List[String]): Double = {
    if(A.length>1)
      A(0).split(" ")(0).toDouble*A(1).split(" ")(1).toDouble+getLeft(A.drop(1))
    else 0
  }
  def getRight(A: List[String]): Double = {
    if(A.length>1)
      A(0).split(" ")(1).toDouble*A(1).split(" ")(0).toDouble+getRight(A.drop(1))
    else 0
  }

  def dist(A: List[String]): Double = {
    Math.abs((getLeft(A)-getRight(A))/2)
  }
}
