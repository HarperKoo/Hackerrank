package com.harper.hourrank_17

/**
  * Created by harperkoo on 2/3/17.
  */
object organizing_containers_of_balls {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val q = sc.nextInt();
    var a0 = 0;
    while(a0 < q){
      val n = sc.nextInt();
      val M = Array.ofDim[Int](n,n);
      for( m_i <- 0 to n-1) {
        for(m_j <- 0 to n-1){
          M(m_i)(m_j) = sc.nextInt();
        }
      }
      // your code goes here
      val rowSum = M.toList.map(_.sum)
      val colSum = M.toList.transpose.map(_.sum)
      println(if (rowSum.sorted == colSum.sorted) "Possible" else "Impossible")
      a0+=1;
    }
  }
}
