package com.harper.daily

/**
  * Created by harperkoo on 12/27/16.
  */
object rotate_string {

  def rotateString(S: String): String ={
    val sj = new java.util.StringJoiner(" ")
    var ss = S
    for(n<-1 to S.length){
      ss = ss.substring(1)+ss.charAt(0)
      sj.add(ss)
    }
    return sj.toString
  }

  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val T = sc.nextInt()
    sc.nextLine()
    for(n <- 1 to T){
      val S = sc.nextLine()
      println(rotateString(S))
    }
  }
}
