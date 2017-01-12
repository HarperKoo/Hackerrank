package com.harper.functional

/**
  * Created by harperkoo on 1/6/17.
  * https://www.hackerrank.com/challenges/pascals-triangle
  */
object pascals_triangle {

  def printNum(n:Int,r:Int):Int = {
    factorial(n)/(factorial(r)*factorial(n-r))
  }

  def printLevel(n:Int) = {
    for(i <- 0 until n)
      print(printNum(n-1,i) + " ")
    println()
  }

  def factorial(n:Int):Int = if(n==0) 1 else n * factorial(n-1)

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val K = sc.nextInt()
    for (i <- 1 to K){
      printLevel(i)
    }
  }
}
