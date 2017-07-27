package com.harper.functional.adhoc

/**
  * Created by harperkoo on 7/25/17.
  * https://www.hackerrank.com/challenges/missing-numbers-fp
  */
object missing_numbers_fp {
  def main(args: Array[String]){
    scala.io.StdIn.readLine()
    val a=scala.io.StdIn.readLine().split(' ').map(_.toInt)
    scala.io.StdIn.readLine()
    val b=scala.io.StdIn.readLine().split(' ').map(_.toInt)
    val m=b.min
    val z=new Array[Int](101)
    for(x<-a)z(x-m)-=1
    for(x<-b)z(x-m)+=1
    println( z.zipWithIndex.filter(_._1>0).map(_._2+m).mkString(" ") )
  }
}
