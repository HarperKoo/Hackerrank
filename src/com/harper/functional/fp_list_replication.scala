package com.harper.functional

/**
  * Created by harperkoo on 1/4/17.
  * https://www.hackerrank.com/challenges/fp-list-replication
  */
object fp_list_replication {

  def f(num:Int,arr:List[Int]):List[Int] = {
    arr.foldLeft(List[Int]()){
      (retArr,a)=>{
          retArr ::: List.fill(num)(a)
      }
    }
  }

  def f2(num:Int, arr:List[Int]) : List[Int] = arr match {
    case Nil => Nil
    case x::xs => List.fill(num)(x) ::: f2(num, xs)
  }

  def main(args: Array[String]): Unit = {
    println(f(3,List(1,2,3,4,5)))
    println(f2(3,List(1,2,3,4,5)))
  }
}
