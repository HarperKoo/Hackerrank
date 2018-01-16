package com.harper.functional.functional

/**
  * Created by harperkoo on 8/17/17.
  * https://www.hackerrank.com/challenges/kmp-fp
  * https://hr-testcases-us-east-1.s3.amazonaws.com/2175/input05.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1503058467&Signature=LirdGpwcr7ailpBaWpQecv2uWL0%3D&response-content-type=text%2Fplain
  * https://hr-testcases-us-east-1.s3.amazonaws.com/2175/output05.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1503058469&Signature=5R78khVkH9DJnrXKzSMeCk%2BR%2FE0%3D&response-content-type=text%2Fplain
  */
object kmp_fp {

  def kmp_search(text:String, pat:String):Boolean = {
    var i = 0
    while( i < text.length){
      var sub_str = ""
      var common_length = 0
      var j = 0
//      println(i,j,text(i),pat(j))
      while(text(i) == pat(j)){
        if(j < pat.length-1){
          if(i >= text.length-1)
            return false
          else{
            sub_str += text(i)
            common_length += 1
            i += 1
            j += 1
          }
        } else
          return true
      }
      i -= j
      j = 0
      val move_index = if(sub_str.length > 1) common_length - sub_match(sub_str) else 0
//      println(i,j,common_length,sub_str,move_index)
      i += (if(move_index == 0) 1 else move_index)//TODO
    }
    false
  }


  def sub_match(sub_str:String):Int = {
    val pre = prefix(sub_str)
    val suf = suffix(sub_str)
    val compare_ps = pre.zip(suf).filter(x=>x._1 == x._2)
    if( compare_ps.isEmpty ) 0 else compare_ps.head._1.length
  }

  def prefix(sub_str:String):List[String] = {
    val pre_sub_str = sub_str.substring(0,sub_str.length-1)
    if(pre_sub_str.length == 1) List(pre_sub_str) else pre_sub_str::prefix(pre_sub_str)
  }

  def suffix(sub_str:String):List[String] = {
    val suf_sub_str = sub_str.substring(1,sub_str.length)
    if(suf_sub_str.length == 1) List(suf_sub_str) else suf_sub_str::suffix(suf_sub_str)
  }

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    (1 to T).foreach(_ => {
      val text = scala.io.StdIn.readLine()
      val pat = scala.io.StdIn.readLine()
      println(if(kmp_search(text,pat)) "YES" else "NO")
    }
    )
  }
}


object Solution {

  val YES = "YES"
  val NO = "NO"

  def solution(text: String, pat: String): String = if(text.indexOf(pat) != -1) YES else NO

  def main(args: Array[String]) {
    val count = scala.io.StdIn.readInt()
    val result = (1 to count).map{_ =>
      val text = scala.io.StdIn.readLine()
      val pat = scala.io.StdIn.readLine()
      solution(text, pat)
    }
    result.foreach(println)
  }
}