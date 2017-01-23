package com.harper.others

/**
  * Created by harperkoo on 1/20/17.
  * Define amazing number as: its value is less than or equal to its index. Given a circular array, find the starting position, such that the total number of amazing numbers in the array is maximized.
Example 1: 0, 1, 2, 3
Ouptut: 0. When starting point at position 0, all the elements in the array are equal to its index. So all the numbers are amazing number.
Example 2: 1, 0 , 0
Output: 1. When starting point at position 1, the array becomes 0, 0, 1. All the elements are amazing number.
If there are multiple positions, return the smallest one.

should get a solution with time complexity less than O(N^2)
  */
object amazing_number {
  def main(args: Array[String]): Unit = {
    val circular = scala.io.StdIn.readLine().split(",").map(_.toInt).toList
    val cir2 = circular:::circular
    val output = new scala.collection.mutable.HashMap[Int,Int]
    var start_step = 0
    var start = -1
    for(i <- (0 until cir2.length)){
      if(cir2(i) <= start_step){
        if(start_step == 0)
          start = i
        output(start) = start_step
        println(i,cir2(i),start_step)
        start_step+=1
      }else
        start_step = 0
    }
    println(output)
  }
}
//1,2,3,4,0,0,0,1,2,3,4,1,2,3,100,0,1,2,3,4,5,6,1,101,0,0,0,0,0,0,0,3,5,7,1,2
