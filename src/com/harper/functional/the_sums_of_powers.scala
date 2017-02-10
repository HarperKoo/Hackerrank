package com.harper.functional

/**
  * Created by harperkoo on 1/23/17.
  */
object the_sums_of_powers {
  def main(args: Array[String]): Unit = {
    val sum = scala.io.StdIn.readInt()
    val power = scala.io.StdIn.readInt()
    val max = Math.pow(sum,1d/power).toInt
    val options = for (i <- 1 to max) yield {
      math.pow(i, power).toInt
    }
    println(nWays(sum, options.toList).size)
  }

  def nWays(expectedSum: Int, availableOptions: List[Int]): List[List[Int]] = {
    if (expectedSum == 0)
      return List(List())

    if (availableOptions isEmpty)
      return List()

    val ways = for (x <- availableOptions) yield {
      val rest: List[Int] = availableOptions.filter(_ != x)
      val next = expectedSum - x

      next match {
        case n if n < 0 => return nWays(expectedSum, rest)
        case 0 => return nWays(expectedSum, rest) :+ List(x)
        case _ =>
          val l1 = nWays(expectedSum, rest)
          val l2 = nWays(next, availableOptions.dropWhile(_ <= x)).map(x :: _)
          return l1 ++ l2
      }
    }
    ways.flatMap(x => x)
  }
}

object Solution_WHiZard {

  def ways(X:Int, prev:Int, N:Int):Int = X match {
    case x if x < 0 => 0
    case 0 | 1 => 1
    case _ => (prev to 2 by -1)
      .map(x => (x, X-Math.pow(x, N).toInt))
      .map(x => ways(x._2, x._1 - 1, N))
      .sum
  }

  def numberOfWays(X:Int,N:Int):Int = ways(X, Math.pow(X, 1d/N).toInt, N)

  def main(args: Array[String]) {
    println(numberOfWays(readInt(),readInt()))
  }
}


object Solution_jsc {
  def numberOfWays(x: Int, n: Int, i: Int = 1): Int = {
    def pow(x: Int): Int = math.pow(x, n).toInt
    if (pow(i) > x) 0
    else if (pow(i) == x) 1
    else {
      numberOfWays(x, n, i + 1) + numberOfWays(x - pow(i), n, i + 1)
    }
  }

  def main(args: Array[String]) {
    println(numberOfWays(readInt(),readInt()))
  }
}