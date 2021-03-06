package com.harper.functional

/**
  * Created by harperkoo on 2/15/17.
  * https://www.hackerrank.com/challenges/prison-transport
  */
object prison_transport {
  def main(args: Array[String]): Unit = {
    val N = scala.io.StdIn.readInt()
    val M = scala.io.StdIn.readInt()
    val immate_group = new Array[Set[Int]](M)
    var all = (1 to N).toSet
    for(i<-0 to M-1){
      immate_group(i) = scala.io.StdIn.readLine().split(" ").map(_.toInt).toSet
      all = all -- immate_group(i)
      if(i>0){
        for(j<-0 to i-1){
          println(i,j)
          println(immate_group(i),immate_group(j))
          if(immate_group(j) != null && immate_group(i) != null && ((immate_group(j) & immate_group(i)).size > 0)){
            immate_group(i) = immate_group(j) | immate_group(i)
            immate_group(j) = null
          }
        }
      }
    }
    var output = all.size
    for(i<- 0 to M-1 ){
      if(immate_group(i) != null){
        val th = Math.ceil(Math.sqrt(immate_group(i).size)).toInt
        output += th
      }
    }
    println(output)
  }
}
