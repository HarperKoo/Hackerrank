package com.harper.functional

/**
  * Created by harperkoo on 2/6/17.
  * https://www.hackerrank.com/challenges/super-digit
  */
object super_digit {

  def super_digit(input:List[Char]):List[Char] = {
//    println(input)
    if (input.length == 1)
      input
    else{
      val input_int = input.map(_.toInt - 48)
      super_digit(input_int.sum.toString.toList)
    }
  }

  def main(args: Array[String]): Unit = {
    val in = scala.io.StdIn.readLine().split(" ")
    val n = in(0).toList
    val k = in(1).toInt
    println(super_digit((k * super_digit(n).mkString("").toInt).toString.toList).mkString(""))
  }
}
