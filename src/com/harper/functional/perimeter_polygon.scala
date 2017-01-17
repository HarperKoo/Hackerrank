package com.harper.functional

/**
  * Created by harperkoo on 1/16/17.
  * https://www.hackerrank.com/challenges/lambda-march-compute-the-perimeter-of-a-polygon
  */
object perimeter_polygon {
  def main(args: Array[String]) {
    val N = scala.io.StdIn.readInt
    val points = (1 to N).map(_ => scala.io.StdIn.readLine()).toList
    println(if(N>1) dist(points:+points.head) else "0")
  }
  def dist(A: List[String]): Double = {
    if(A.length>=2)
      scala.math.sqrt(
        scala.math.pow((A(0).split(" ")(0).toDouble-A(1).split(" ")(0).toDouble),2)
          + scala.math.pow((A(0).split(" ")(1).toDouble-A(1).split(" ")(1).toDouble),2)) + dist(A.drop(1))
    else 0
  }
}
