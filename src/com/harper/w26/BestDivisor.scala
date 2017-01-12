package com.harper.w26

/**
  * Created by harperkoo on 12/1/16.
  */
object BestDivisor {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    var tmp = 0;
    var output = n;
    val large = Math.ceil(Math.sqrt(n.toDouble)).toInt;
    for(i <- 1 to large){
      if(n%i == 0){
        val outS = getSum(i);
        if(outS > tmp){
            tmp = outS;
            output = i;
        }else if(outS == tmp){
          if(i < output){
            tmp = outS;
            output = i;
          }
        }
        val outB = getSum(n/i);
        if(outB > tmp){
          tmp = outB;
          output = n/i;
        }else if(outB == tmp){
          if(n/i < output){
            tmp = outB;
            output = n/i;
          }
        }
      }
    }
    println(output)
  }

  def getSum(num:Int):Int = {
    val numCList = num.toString.toList;
    numCList.foldLeft(0)(_ + _ -48)
  }
}
