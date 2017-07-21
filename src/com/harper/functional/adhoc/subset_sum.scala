package com.harper.functional.adhoc

/**
  * Created by harperkoo on 6/8/17.
  * https://www.hackerrank.com/challenges/subset-sum
  */
object subset_sum {

  def compare_subset(S: Long, A: Array[Long]): Int ={
      val len = A.length
      for(l<-0 until len){
        if(S <= A(l))
          return l+1
      }
      return -1
  }

  def binary_search(S: Long, A: Array[Long]): Int = {
    var min : Int = 0
    var max : Int = A.length
    while(min<max){
      val mid:Int = min+((max-min) >> 1);
      val midVal:Long = A(mid)
      if(S>midVal)
        min = mid+1
      else
        max = mid;
    }
    return min+1
  }


  def main(args: Array[String]): Unit = {
    val N : Int = scala.io.StdIn.readInt()
    val A : Array[Long] = scala.io.StdIn.readLine().split(" ").map(_.toLong).sortBy(-_);
    for(i<-1 until A.length){
      A(i) += A(i-1)
    }
    val T= scala.io.StdIn.readInt()
    for(t<-1 to T){
      val S = scala.io.StdIn.readLine().toLong
      val output = binary_search(S,A)
      if(output<=A.length) println(output) else println(-1)
    }
  }
}
