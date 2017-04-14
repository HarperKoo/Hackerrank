package com.harper.functional
/**
  * Created by harperkoo on 3/15/17.
  * https://www.hackerrank.com/challenges/filter-elements
  */

import scala.collection.mutable.LinkedHashMap


object filter_elements {
  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    for(t<-0 to T){
      val K = scala.io.StdIn.readLine().split(" ").toList(1).toInt
      val A = scala.io.StdIn.readLine().split(" ").toList
      val A_map = A.zipWithIndex.map(x => (x,1))
      val group_A_map = A_map groupBy (_._1._1)
      val lhm =  LinkedHashMap(group_A_map.toSeq sortBy (_._2.head._1._2):_*)
      val outMap = lhm mapValues ( _.map(_._2).sum) filter (_._2>=K)
      if( outMap.keys.size == 0) println("-1") else println(outMap.keys.mkString(" "))
    }
  }
}
