package com.harper.algorithms.Strings

/**
  * https://www.hackerrank.com/challenges/strong-password/problem
  */

object strong_password extends App {
  val numbers = "0123456789"
  val lower_case = "abcdefghijklmnopqrstuvwxyz"
  val upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val special_characters = "!@#$%^&*()-+"

  val T = scala.io.StdIn.readInt()
  val password = scala.io.StdIn.readLine()
  println(check_password_strong(T, password))

  def check_password_strong(len: Int,password: String): Int = {
    val password_list = password.toList
    val satisfy_count = has_numbers(password_list) + has_lower(password_list) + has_upper(password_list) +
      has_special(password_list)
    if (len >=6) 4 - satisfy_count else (6-len).max(4 - satisfy_count)
  }

  def has_numbers(password_list: List[Char]): Integer ={
    if(password_list.exists(numbers.toList.contains)) 1 else 0
  }

  def has_lower(password_list: List[Char]): Integer ={
    if(password_list.exists(lower_case.toList.contains)) 1 else 0
  }

  def has_upper(password_list: List[Char]): Integer ={
    if(password_list.exists(upper_case.toList.contains)) 1 else 0
  }

  def has_special(password_list: List[Char]): Integer ={
    if(password_list.exists(special_characters.toList.contains)) 1 else 0
  }
}

