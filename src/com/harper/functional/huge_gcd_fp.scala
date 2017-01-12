package com.harper.functional

/**
  * Created by harperkoo on 12/27/16.
  * https://www.hackerrank.com/challenges/huge-gcd-fp
  */
object huge_gcd_fp {

  def factor_divisor(nums:List[Int]):Map[Int,Int] = {
    var lst = List[Int]()
    for(num <- nums){
      var numr = num
      val idxList = (2 to num toList)
      for ( i <- idxList){
        while(numr%i == 0){
          lst = lst :+ i
          numr = numr/i
        }
      }
    }

    lst.foldLeft(Map[Int,Int]()){
      (retMap,i) => {
        retMap + (i -> ((retMap getOrElse (i,0)) +1))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val sc  = new java.util.Scanner(System.in)
    val N = sc.nextInt()
    sc.nextLine()
    val as = sc.nextLine().split(" ").map(_.toInt).toList
    val M = sc.nextInt()
    sc.nextLine()
    val bs = sc.nextLine().split(" ").map(_.toInt).toList
    val map1 = factor_divisor(as)
    println(map1)
    val map2 = factor_divisor(bs)
    println(map2)
    val list = map1.toList ++ map2.toList
    val merged = list.groupBy ( _._1) .map { case (k,v) => k -> v.map(_._2).min }
    println(merged)
    val diff =  (map1.keySet -- map2.keySet) ++ (map2.keySet -- map1.keySet)
    println(diff)
    var sum = 1L
    for(l <- merged.toList){
      if(!(diff contains l._1 ))
        println(sum,l._1,l._2)
        sum = (sum*l._1.toLong*l._2.toLong)%1000000007L
    }
    println(sum)
  }
}

object huge_gcd_fp2{
  def gcd(a: Long, b: Long): Long = {
    if (a < b) return gcd(b, a)
    if (b == 0) return a
    return gcd(b, a % b)
  }

  def main(a: Array[String]) {
    val sc  = new java.util.Scanner(System.in)
    val n = sc.nextLine().toInt
    val ns = sc.nextLine().split(' ').map(x => x.toLong)
    val m = sc.nextLine().toInt
    val ms = sc.nextLine().split(' ').map(x => x.toLong)
    var result = 1L

    for (i <- 0 until n) {
      for (j <- 0 until m) {
        val g = gcd(ns(i), ms(j))
        ns(i) /= g
        ms(j) /= g
        result = (result * g) % 1000000007
      }
    }
    println(result)
  }
}