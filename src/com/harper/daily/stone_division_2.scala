package com.harper.daily

/**
  * Created by harperkoo on 12/16/16.
  */
//This solution is wrong
object stone_division_2 {
  def getBiggestFactor(y:Long,sortedSk:List[Long]): Long ={
    val m = sortedSk.length
    for(j <- m to 1 by -1){
      if(y%sortedSk(j-1) == 0 && y > sortedSk(j-1)) {
        println(y, sortedSk(j - 1), y / sortedSk(j - 1))
        return 1l + (y/sortedSk(j - 1)) * getBiggestFactor(sortedSk(j - 1), sortedSk)
      }
    }
    0l
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val q = sc.nextInt()
    for(i <- 1 to q){
      val n = sc.nextLong()
      val m = sc.nextInt()
      sc.nextLine()
      val S = sc.nextLine().split(" ").map(_.toLong).toList.sorted
      println("result",getBiggestFactor(n,S))
    }
  }
}
