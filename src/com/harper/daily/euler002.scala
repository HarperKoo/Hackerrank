package com.harper.daily

/**
  * Created by harperkoo on 1/9/17.
  * https://www.hackerrank.com/contests/projecteuler/challenges/euler002
  */
object euler002 {
  def fibonacci(index:Long):Long = {
    index match {
      case 0 => 0L
      case 1 => 2L
      case 2 => 8l
      case 3 => 34l
      case 4 => 144l
      case 5 => 610l
      case 6 => 2584l
      case 7 => 10946l
      case 8 => 46368l
      case 9 => 196418l
      case 10 => 832040l
      case 11 => 3524578l
      case 12 => 14930352L
      case 13 => 63245986L
      case 14 => 267914296l
      case 15 => 1134903170l
      case 16 => 4807526976l
      case 17 => 20365011074l
      case 18 => 86267571272l
      case 19 => 365435296162l
      case 20 => 1548008755920l
      case 21 => 6557470319842l
      case 22 => 27777890035288l
      case 23 => 117669030460994l
      case 24 => 498454011879264l
      case 25 => 2111485077978050l
      case 26 => 8944394323791464l
      case 27 => 37889062373143906l
      case _ =>4L*fibonacci(index-1)+fibonacci(index-2)
    }
  }

  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in);
    val t = sc.nextInt();
    for(i<-1 to t){
      val n = sc.nextLong();
      var i = 0L
      var sum = 0L
      var out = fibonacci(i)
      while(out<=n){
        sum+=out
        i+=1L
        out = fibonacci(i)
      }
      println(sum)
    }
  }
}
