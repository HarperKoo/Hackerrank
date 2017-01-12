package com.harper.daily

import java.util.Scanner

/**
  * Created by harperkoo on 12/7/16.
  */
object minimum_loss {
  def findmin(buyCosts:List[Long],sellCost:Long): Long ={
    val buyCostBig = buyCosts.filter(_ > sellCost)
    buyCostBig match {
      case x if x.length > 0 => (buyCostBig.min - sellCost);
      case _ =>  10000000000000000L;
    }
  }


  def main(args:Array[String]): Unit ={
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    sc.nextLine()
    var minLost = 10000000000000000L
    val prices = sc.nextLine().split(" ").map(_.toLong).toList
    for(i <- 1 until prices.length){
      val lostcost = findmin(prices.take(i),prices(i))
      if(lostcost < minLost)
        minLost = lostcost
    }
    println(minLost)
  }
}
