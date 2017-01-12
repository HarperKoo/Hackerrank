package com.harper.functional

/**
  * Created by harperkoo on 1/11/17.
  * https://www.hackerrank.com/challenges/eval-ex
  */
object eval_ex {

  def power_factorial(x:Double):Double = {
    (0 to 9).toList.map(n => Math.pow("%.4f".format(x).toDouble,n)/factorial(n)).sum
  }

  def factorial(n:Int):Int = {
    n match {
      case 0 => 1
      case 1 => 1
      case y => y*factorial(y-1)
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    for(i <- 1 to n){
      val x = sc.nextDouble();
      println("%.4f".format(power_factorial(x)))
    }
  }
}
