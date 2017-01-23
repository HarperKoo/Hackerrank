package com.harper.functional

/**
  * Created by harperkoo on 1/22/17.
  */
object string_o_permute {
  def main(args:Array[String])={
    val num = scala.io.StdIn.readInt()
    for(i<-(1 to num)){
      println((swaptwo(scala.io.StdIn.readLine().toString.toList.map(_.toString))).mkString(""))
    }

  }
  def swaptwo(l: List[String]): List[(String)] = l match {
    case Nil => Nil
    case a :: b :: rest =>
      b :: a :: swaptwo(rest)
  }
}
