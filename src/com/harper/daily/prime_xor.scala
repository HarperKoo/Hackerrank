package com.harper.daily

/**
  * Created by harperkoo on 12/12/16.
  */
object prime_xor {
  def isPrime(e:Int) = {
    val sqe = Math.sqrt(e).toInt
    if(e<=1) false
    else if (e == 2) true
    else !(2 to sqe).exists(e % _ == 0)
  }

  def getAllXor(elements:List[Int]) = {

  }

  def main(args:Array[String]): Unit ={
    val sc = new java.util.Scanner(System.in)
    val number = sc.nextInt()
    for( n <- 1 to number ){
      val m = sc.nextInt()
      sc.nextLine()
      val elements = sc.nextLine().split(" ").map(_.toInt).toList
    }
  }
}
