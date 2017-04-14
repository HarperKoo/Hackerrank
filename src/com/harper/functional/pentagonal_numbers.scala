package com.harper.functional

/**
  * Created by harperkoo on 3/16/17.
  * https://www.hackerrank.com/challenges/pentagonal-numbers
  */
object pentagonal_numbers {
  def P(n:Long):Long = {
//    if(n == 1) 1 else 3*(n-1)+1+P(n-1)
    n+n*(n-1)*3/2
  }

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    for(t<-1 to T){
      val n = scala.io.StdIn.readLong()
      println(P(n))
    }
  }
}
