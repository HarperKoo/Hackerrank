package com.harper.w26

/**
  * Created by harperkoo on 12/1/16.
  */
object twins {

  def isPrime(n: Int): Boolean = {
    val ceiling = math.sqrt(n.toDouble).toInt
    (2 to ceiling) forall (x => n % x != 0)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    val m = sc.nextInt();
    var cnt = 0;
    var tmp = 0;
    for(i<-n to m){
      if(isPrime(i)){
//        println(s"isPrime:$i")
        if(tmp == 0) tmp = i
        else{
          if(i-tmp == 2) cnt = cnt + 1
          tmp = i
        }
      }
    }
    println(cnt)
  }


}
