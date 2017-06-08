package com.harper.functional.Memoization_DP

/**
  * Created by harperkoo on 4/14/17.
  * https://www.hackerrank.com/challenges/different-ways-fp
  */
object different_ways_fp {

  def multifple_tail(max:Long): Long = {
    def multifple(max:Long,one:Long): Long =
      if (max > 1) multifple(max-1,(one*max))
      else one
    multifple(max,1)
  }

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    for(i<-1 to T){
      val n = scala.io.StdIn.readLine().split(" ").toList.map(_.toInt)
      println(multifple_tail(n(0))/(multifple_tail(n(1))*multifple_tail(n(0)-n(1))))
    }
  }
}

import Array._
object Solution
{
  def main(args: Array[String])
  {
    val C = ofDim[Int](1000, 1001);
    C(0)(0) = 1;
    C(0)(1) = 1;
    for(i <- 1 to 999)
    {
      C(i)(0) = 1;
      C(i)(i + 1) = 1;
      for(j <- 1 to i)
      {
        C(i)(j) = (C(i - 1)(j - 1) + C(i - 1)(j)) % 100000007;
      }
    }
    val t = readInt;
    for(i<-1 to t)
    {
      val p = readLine.split(" ").map( _.toInt);
      println(C(p(0) - 1)(p(1)));
    }
  }
}