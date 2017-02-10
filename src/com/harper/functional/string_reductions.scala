package com.harper.functional

import scala.collection.mutable.ListBuffer

/**
  * Created by harperkoo on 1/26/17.
  * https://www.hackerrank.com/challenges/string-reductions
  */
object string_reductions {
  def main(args: Array[String]): Unit = {
    val str = scala.io.StdIn.readLine().toString.toList
    val output = new ListBuffer[Char]
    for (s<-str){
      if (!output.contains(s)) output.append(s)
    }
    println(output.mkString(""))
  }
}
