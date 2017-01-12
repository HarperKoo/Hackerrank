package com.harper.functional

/**
  * Created by harperkoo on 1/4/17.
  */
object gcd {
  def gcd(x: Int, y: Int): Int =
  {
    // You only need to fill up this function
    // To return the value of the GCD of x and y
    if (x < y) return gcd(y, x)
    if (y == 0) return x
    return gcd(y, x % y)
  }


  /**This part handles the input/output. Do not change or modify it **/
  def acceptInputAndComputeGCD(pair:List[Int]) = {
    println(gcd(pair.head,pair.reverse.head))
  }

  def main(args: Array[String]) {
    /** The part relates to the input/output. Do not change or modify it **/
    acceptInputAndComputeGCD(readLine().trim().split(" ").map(x=>x.toInt).toList)

  }
}
