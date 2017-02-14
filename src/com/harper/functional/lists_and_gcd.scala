package com.harper.functional

import scala.annotation.tailrec

/**
  * Created by harperkoo on 2/10/17.
  */
object lists_and_gcd {

  def gcd(lista: List[(Int,Int)],listb: List[(Int,Int)]):List[(Int,Int)] = {
//    val mM = lista groupBy{_._1} mapValues(_.map(_._2).min)
    var output = List[(Int,Int)]()
    for(a<-lista)
      for(b<-listb)
        if(a._1 == b._1){
          output = (a._1,(if(a._2 < b._2) a._2 else b._2)) :: output
        }
    output
  }

  def stringtoTuple(s:String):List[(Int,Int)] = {
    val sIdx = s.split(" ").map(_.toInt).toList.zipWithIndex
    sIdx.filter(_._2 % 2 == 0).map(_._1) zip sIdx.filter(_._2 % 2 == 1).map(_._1)
      //sliding(2,2).toList.collect{case List(x,y) => (x,y)}
  }

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()
    var lstn = List[Int]()
    var start = stringtoTuple(scala.io.StdIn.readLine())
    for(i<- 2 to n){
      val compair = stringtoTuple(scala.io.StdIn.readLine())
      start = gcd(start,compair)
    }
    println(scala.util.Sorting.stableSort(start,(e1: (Int, Int), e2: (Int, Int)) => e1._1 < e2._1)
      .toList.flatMap(t => List(t._1, t._2)) mkString " ")
  }
}
