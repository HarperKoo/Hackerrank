package com.harper.hourrank_17

/**
  * Created by harperkoo on 2/3/17.
  * NOT RIGHT
  */
object gcd_matrix {
  def gcd(x: Int, y: Int): Int =
  {
    // You only need to fill up this function
    // To return the value of the GCD of x and y
    if (x < y) return gcd(y, x)
    if (y == 0) return x
    return gcd(y, x % y)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val n = sc.nextInt();
    val m = sc.nextInt();
    val q = sc.nextInt();
    val a = new Array[Int](n);
    for(a_i <- 0 to n-1) {
      a(a_i) = sc.nextInt();
    }
    val b = new Array[Int](m);
    for(b_i <- 0 to m-1) {
      b(b_i) = sc.nextInt();
    }
    val M = Array.ofDim[Int](n,m);
    for( m_i <- 0 to n-1) {
      for(m_j <- 0 to m-1){
        M(m_i)(m_j) = gcd(a(m_i),b(m_j));
      }
    }
    var a0 = 0;
    while(a0 < q){
      val r1 = sc.nextInt();
      val c1 = sc.nextInt();
      val r2 = sc.nextInt();
      val c2 = sc.nextInt();
      // your code goes here
      var out = Set[Int]()
      for(i <- r1 to r2){
        for (j<- c1 to c2){
          out += M(i)(j)
        }
      }
      println(out.size)
      a0+=1;
    }
  }
}
