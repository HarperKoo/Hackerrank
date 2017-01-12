package com.harper.functional

/**
  * Created by harperkoo on 1/6/17.
  * https://www.hackerrank.com/challenges/string-mingling
  */
object string_mingling {

  //TLE
  def merge(P:List[Char],Q:List[Char]):String = {
    val builder = StringBuilder.newBuilder
    val idx = (0 until P.length).toList
    for(i<-idx){
      builder.append(P(i))
      builder.append(Q(i))
    }
    builder mkString ""
  }

  def mergeHead(P:List[Char],Q:List[Char]):List[Char] = {
    if(P.isEmpty) List()
    else (P.head :: Q.head :: mergeHead(P.tail, Q.tail))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val P = sc.nextLine().toList
    val Q = sc.nextLine().toList
    //TLE
//    val output:List[Char] = (P zip Q).foldLeft(List[Char]()){
//      case (arr,pq) =>
//      {
//        arr.:+(pq._1).:+(pq._2)
//      }
//    }
//    println(output mkString "")
    println(mergeHead(P,Q) mkString "")
  }
}

