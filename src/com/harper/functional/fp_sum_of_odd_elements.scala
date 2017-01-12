package com.harper.functional

/**
  * Created by harperkoo on 1/6/17.
  * https://www.hackerrank.com/challenges/fp-sum-of-odd-elements
  * https://www.hackerrank.com/challenges/fp-list-length
  * https://www.hackerrank.com/challenges/fp-update-list
  */
object fp_sum_of_odd_elements {

  def f(arr:List[Int]):Int = {
    arr.filter{case a => (a%2 != 0)}.sum
  }

  //https://www.hackerrank.com/challenges/fp-list-length
  def f2(arr:List[Int]):Int ={
    arr.foldLeft(0){
      (a,i)=>{
        a + 1
      }
    }
  }

  //https://www.hackerrank.com/challenges/fp-update-list
  def f3(arr:List[Int]):List[Int] = {
    arr match {
      case Nil => Nil
      case x::xs if x < 0 => -x :: f3(xs)
      case x::xs => x :: f3(xs)
    }
  }
  val centerList = List(1,11,4)

  def test(arr:scala.collection.mutable.Queue[Int]):Int = {
    val wps = arr.zipWithIndex
    val fcIdx:Int = {
      val centers:scala.collection.mutable.Queue[(Int,Int)] = wps.filter(w => centerList.contains(w._1))
      centers match {
        case y if y.isEmpty => -1
        case y => y.head._2
      }
    }
    println(fcIdx)
    val wps2 = wps.slice(fcIdx+1,wps.length)
    println(wps2)
    if (fcIdx >= 0) wps(fcIdx)._1 else -1
  }

  def main(args: Array[String]): Unit = {
//    println(f(List(3,2,4,6,5,7,8,0,1)))
//    println(f2(List(3,2,4,6,5,7,8,0,1)))
//    println(f3(List(3,2,-4,6,-5,7,8,0,1)))
    println(test(scala.collection.mutable.Queue(4,13,12,3,5,2,5,6,7)))

  }
}
