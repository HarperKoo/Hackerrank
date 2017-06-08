package com.harper.functional.adhoc

/**
  * Created by harperkoo on 6/5/17.
  * https://www.hackerrank.com/challenges/common-divisors
  */
object common_divisors {
  def gcd(a: Long, b: Long): Long = {
    if (a < b) return gcd(b, a)
    if (b == 0) return a
    return gcd(b, a % b)
  }

  def factors(a: Int):Int = {
    var init = List(1L)
    if(a == 1) return 1
    if(a == 2) return 2
    for(f <- 2 to (a/2+1)){
      if(a%f == 0)
        init = f :: init
    }
    return init.length+1
  }

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    for (t<-0 to T){
      val LM = scala.io.StdIn.readLine().split(" ")
      val L = LM(0).toInt
      val M = LM(1).toInt
      val LM_gcd = gcd(L,M)
      println(factors(LM_gcd.toInt))
    }
  }
}
