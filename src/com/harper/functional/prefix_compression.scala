package com.harper.functional

/**
  * Created by harperkoo on 1/23/17.
  */
object prefix_compression {
  def main(args:Array[String]):Unit = {
    val x = scala.io.StdIn.readLine().toString.toList
    val y = scala.io.StdIn.readLine().toString.toList
    val xy = (x zip y)
    val ret = xy.takeWhile(x =>(x._2 == x._1))
    val p = ret.map(_._1).mkString("")
    val p_len = p.length
    val xp = x.drop(p_len)
    val yp = y.drop(p_len)
    println(p_len+" "+p)
    println(xp.length+" "+xp.mkString(""))
    println(yp.length+" "+yp.mkString(""))
  }
}
