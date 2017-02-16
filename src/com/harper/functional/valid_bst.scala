package com.harper.functional

/**
  * Created by harperkoo on 2/14/17.
  * https://www.hackerrank.com/challenges/valid-bst
  * 以root大小分组:
  *   num2>num1 && num3 < num1 => no
  */
object valid_bst {
  def compair_tripple(root:Int, sub_bst:List[Int]):Boolean = {
    val out = sub_bst.drop(sub_bst.takeWhile(_<root).length)
//    println(out,out.filter(_<root))
    if(out.filter(_<root).length != 0)
      false
    else
      true
  }

  def main(args: Array[String]): Unit = {
    val T = scala.io.StdIn.readInt()
    for(t<-1 to T){
      val N = scala.io.StdIn.readInt()
      val bst_preorder = scala.io.StdIn.readLine().split(" ").map(_.toInt).toList
      var output = "YES"
      if(bst_preorder.length < 3)
        println(output)
      else {
        for(i<-1 to bst_preorder.length-2){
          if(compair_tripple(bst_preorder(i-1),bst_preorder.drop(i)) == false)
            output = "NO"
        }
        println(output)
      }
    }
  }
}
