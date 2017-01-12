package com.harper.daily

/**
  * Created by harperkoo on 12/28/16.
  * https://www.hackerrank.com/challenges/remove-duplicates/submissions/code/34686099
  */
object remove_duplicates {
  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val sc = new java.util.Scanner(System.in)
    val input = sc.next.toList
    for (i<-input.distinct)
      print(i)
  }
}
