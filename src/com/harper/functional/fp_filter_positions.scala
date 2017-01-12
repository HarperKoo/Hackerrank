package com.harper.functional

/**
  * Created by harperkoo on 1/5/17.
  * https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list?h_r=next-challenge&h_v=zen
  */
object fp_filter_positions {
  def f(arr:List[Int]):List[Int] = {
    arr.drop(1).grouped(2).map(_.head).toList
  }

  def f2(arr:List[Int]):List[Int] = {
    arr.zipWithIndex.filter{case (a,i) => (i%2 != 0)}.map(_._1)
  }

  def main(args: Array[String]): Unit = {
    println(f(List(1,2,3,4,5,6,7)))
    println(f2(List(1,2,3,4,5,6,7)))
  }
}
