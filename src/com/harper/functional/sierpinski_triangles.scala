package com.harper.functional

/**
  * Created by harperkoo on 1/19/17.
  * https://www.hackerrank.com/challenges/functions-and-fractals-sierpinski-triangles
  */
object sierpinski_triangles {
  def drawTriangles(n: Int) {
    //Draw the N'th iteration of the fractal as described
    // in the problem statement
    val triangles =  Array.fill[Char](32,63){'_'}
    for( i <- (0 to 31).toList){
      for(t <- (31-i to 31+i).toList){
        triangles(i)(t)='1'
      }
    }
    if(n >= 1){
      for( i <- (0 to 15).toList){
        for(t <- (i to 30-i).toList){
          triangles(16+i)(16+t)='_'
        }
      }
    }
    if(n >= 2){
      for( i <- (0 to 7).toList){
        for(t <- (i to 14-i).toList){
          triangles(8+i)((31-7)+t)='_'
          triangles(24+i)((31-23)+t)='_'
          triangles(24+i)((8+16+16)+t)='_'
        }
      }
    }
    if(n >= 3){
      for( i <- (0 to 3).toList){
        for(t <- (i to 6-i).toList){
          val x = List(4,12,20,28)
          val y = List(4,12,20,28,36,44,52)
          for(xi<-x)
            for(yi<-y){
              triangles(xi+i)(yi+t)='_'
            }
        }
      }
    }
    if(n >= 4){
      for( i <- (0 to 1).toList) {
        for (t <- (i to 2 - i).toList) {
          val x = List.range(2, 32, 4)
          val y = List.range(2, 62, 4)
          for(xi<-x)
            for(yi<-y){
              triangles(xi+i)(yi+t)='_'
            }
        }
      }
    }
    if(n == 5){
      val x = List.range(1, 32, 2)
      val y = List.range(1, 62, 2)
      for(xi<-x)
        for(yi<-y){
          triangles(xi)(yi)='_'
        }
    }


    for(i <- (0 to 31).toList){
      println(triangles(i).toList.mkString(""))
    }
  }



  def main(args: Array[String]) {
    drawTriangles(scala.io.StdIn.readInt())
  }
}

object Solution {

  def sierp(b:Array[Array[Char]], x:Int, y:Int, h:Int, w:Int, n:Int):Array[Array[Char]] = n match {
    case 0 =>
      for(i <- 0 until h) {
        b(x+i)(y+w/2) = '1'
        for(j <- 0 until i+1) {
          b(x+i)(y+w/2-j) = '1'
          b(x+i)(y+w/2+j) = '1'
        }
      }
      return b
    case _ =>
      sierp(sierp(sierp(b, x, y+w/4+1, h/2, w/2, n-1), x+h/2, y+0, h/2, w/2, n-1), x+h/2, y+w/2+1, h/2, w/2, n-1)
  }

  def drawTriangles(N:Int) = {
    sierp(List.fill(32)(List.fill(63)('_').toArray).toArray, 0, 0, 32, 63, N)
      .foreach(x => println(x.mkString("")))
  }

  def main(args: Array[String]) {
    drawTriangles(scala.io.StdIn.readInt())
  }
}