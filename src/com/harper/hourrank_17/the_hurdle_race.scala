package com.harper.hourrank_17

/**
  * Created by harperkoo on 2/3/17.
  */
object the_hurdle_race {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    val k = sc.nextInt();
    val height = new Array[Int](n);
    for(height_i <- 0 to n-1) {
      height(height_i) = sc.nextInt();
    }
    val out = height.max - k
    println(if (out <= 0) 0 else out)
  }
}
