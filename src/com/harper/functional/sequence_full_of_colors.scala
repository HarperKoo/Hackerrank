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

object Solution2 {

  def isFullOfColors(colors: String): Boolean = {
    val diffsOnPrefixes = colors.scanLeft((0, 0)) {
      case(c1, c2) => c2 match {
        case 'R' => (c1._1 - 1, c1._2)
        case 'G' => (c1._1 + 1, c1._2)
        case 'Y' => (c1._1, c1._2 - 1)
        case 'B' => (c1._1, c1._2 + 1)
      }
    }
    diffsOnPrefixes.forall {
      case(x, y) => -2 < x && x < 2 && -2 < y && y < 2
    } && (diffsOnPrefixes.length == 0 || diffsOnPrefixes.last == (0, 0))
  }

  def main(args: Array[String]) {
    val nTests = io.StdIn.readInt()
    for (i <- 0 until nTests) {
      println(if (isFullOfColors(io.StdIn.readLine())) "True" else "False")
    }
  }
}
