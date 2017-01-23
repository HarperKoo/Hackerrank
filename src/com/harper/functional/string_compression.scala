package com.harper.functional

/**
  * Created by harperkoo on 1/23/17.
  */
object string_compression {

  def compression(input:String):String = {
    var pro = input.toList
    val output = new StringBuilder
    while (!pro.isEmpty){
      val compare = pro.head
      val len = (pro.takeWhile(_ == compare)).length
      output.append(compare+(if(len == 1) "" else len.toString))
      pro = pro.drop(len)
    }
    output.toString()
  }
  def main(args: Array[String]): Unit = {
    val input = scala.io.StdIn.readLine().toString
    println(compression(input))
  }
}
