package com.harper.functional

/**
  * Created by harperkoo on 1/12/17.
  * https://www.hackerrank.com/challenges/functions-or-not
  */
object functions_or_not {
  def main(args: Array[String]): Unit = {
    val sc = new java.util.Scanner(System.in)
    val T = sc.nextInt()
    for(t <- 1 to T){
      var retMap = Map[Int,Int]()
      var output = "YES"
      val N = sc.nextInt()
      for(n <- 1 to N){
          val k = sc.nextInt()
          val v = sc.nextInt()
          if (retMap.get(k).isEmpty)
            retMap += (k -> v)
          else if(retMap(k) != v)
            output = "NO"
      }
      println(output)
    }
  }
}

//没考虑重复的情况
object Solution extends App {
  val in = new java.util.Scanner(System.in)
  def runCase(caseNum: Int) {
    val pairs = List.fill(in.nextInt)((in.nextInt, in.nextInt))
    if(pairs.groupBy(_._1).exists(_._2.size > 1))
      println("NO")
    else
      println("YES")
  }
  (1 to in.nextInt).foreach(runCase)
}