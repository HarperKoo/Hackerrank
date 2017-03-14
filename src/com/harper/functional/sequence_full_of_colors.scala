package com.harper.functional

/**
  * Created by harperkoo on 3/10/17.
  * https://www.hackerrank.com/challenges/sequence-full-of-colors?h_r=next-challenge&h_v=zen
  */
object sequence_full_of_colors {

  def main(args: Array[String]): Unit = {
    val times = scala.io.StdIn.readInt()
    for( i <- 1 to times){
      val balls = scala.io.StdIn.readLine().toCharArray
      var rg = 0
      var yb = 0
      var output = "True"
      for(b<-balls){
        if(b == 'R')
          rg+=1
        else if (b == 'G')
          rg-=1
        else if (b == 'Y')
          yb+=1
        else if (b == 'B')
          yb-=1
        if(rg == 2 || yb ==2)
          output = "False"
      }
      if(rg != 0 || yb != 0)
        output = "False"
      println(output)
    }
  }
}
