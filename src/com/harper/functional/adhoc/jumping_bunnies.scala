package com.harper.functional.adhoc

/**
  * Created by harperkoo on 7/21/17.
  * The least common multiple (LCM)
  * https://www.hackerrank.com/challenges/jumping-bunnies
  */
object jumping_bunnies extends App {

  def gcd(a: Long,b: Long):Long = {
    return if(a % b == 0) b else gcd(b, a%b)
  }

  def lcm(a: Long,b: Long):Long = {
    return a/gcd(a,b)*b
  }

  val N = scala.io.StdIn.readInt()
  val J = scala.io.StdIn.readLine().split(" ") map(_.toLong)
  var i = 1
  var a = J(0)
  while(i< J.length){
    a = lcm(a,J(i))
    i = i+1
  }
  println(a)
}
