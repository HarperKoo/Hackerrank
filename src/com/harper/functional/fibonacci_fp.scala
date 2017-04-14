package com.harper.functional

/**
  * Created by harperkoo on 3/17/17.
  * https://www.hackerrank.com/challenges/fibonacci-fp
  */
object fibonacci_fp {
  def fib(n:Long):Long = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => (fib(n-1)+fib(n-2))//%(100000007)
    }
  }

  def fib_fp(n:Int):Array[Int] = {
    val ff = new Array[Int](n+1)
    ff(0) = 0
    ff(1) = 1
    for(i<-2 to n){
      ff(i) = (ff(i-1)+ff(i-2))%100000007
    }
    ff
  }

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    val ff = fib_fp(10000)
    for (t<-0 to T){
      println(ff(scala.io.StdIn.readInt()))
    }
  }
}
