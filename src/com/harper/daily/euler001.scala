package com.harper.daily

/**
  * Created by harperkoo on 12/28/16.
  * https://www.hackerrank.com/contests/projecteuler/challenges/euler001
  */
object euler001 {
  def sum(N:BigInt):BigInt = {
    if (N == BigInt(1))
      return BigInt(1)
    else if (N == BigInt(0))
      return BigInt(0)
    else
      return (N+BigInt(1))*N/BigInt(2)
  }
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val T = sc.nextInt()
    for (n<-1 to T){
      val n = sc.nextInt()-1
      println(sum(BigInt(n/5))*5+sum(BigInt(n/3))*3-sum(BigInt(n/15))*15)
    }
  }
}
