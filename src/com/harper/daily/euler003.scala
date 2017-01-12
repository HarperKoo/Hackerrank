package com.harper.daily

/**
  * Created by harperkoo on 1/11/17.
  */
object euler003 {

  def pollardRho(n:Long):Long = {
    var nt = n
    if(nt == 1) {
      nt = 2
    }
    else{
      while(nt%2 == 0)
        nt = nt/2
      if(nt > 2){
        for( i <- 3l to Math.sqrt(n).toLong by 2l){
          if(nt > i)
            if(nt%i == 0 )
              nt = pollardRho(nt/i)
        }
      }else
        nt = 2
    }
    nt
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val t = sc.nextInt();
    for(i <- 1 to t){
      val n = sc.nextLong();
      println(pollardRho(n))
    }
  }
}
