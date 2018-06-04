/**
  * https://www.hackerrank.com/challenges/arrays-ds/problem
  * input:
  * 4
  * 4 2 5 1
  * output
  * 1 5 2 4
  */

package main.harper.DataStructures

object arrays_ds {
  /*
   * Complete the reverseArray function below.
   */
  def reverseArray(a: Array[Int]): Array[Int] = {
    val len = a.length
    if(len == 1) a else a(len -1) +: reverseArray(a.slice(0, len-1))
  }


  def main(args: Array[String]) {
    val N = scala.io.StdIn.readInt()
    val arr = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val res = reverseArray(arr)
    println(res.mkString(" "))
  }
}
