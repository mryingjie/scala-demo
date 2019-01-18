package com.demo.scala.homework

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/14 10:41
  */
class HomeWork03 {

  //  1、一个数字如果为正数，则它的signum为1;如果是负数,则signum为-1;如果为0,则signum为0.编写一个函数来计算这个值

  //  2、一个空的块表达式{}的值是什么？() 类型是什么？ Unit
  @Test
  def test02(): Unit = {
    val n = {}
    println(n.toString)
    println(n.isInstanceOf[Unit])
  }

  //  3、针对下列Java循环编写一个Scala版本:
  //  for(int i=10;i>=0;i–)System.out.println(i);
  @Test
  def test03(): Unit = {
    for (i <- 0 to 10 reverse) {
      println(i)

    }
  }

  //  4、编写一个过程countdown(n:Int)，打印从n到0的数字
  @Test
  def test04(): Unit = {
    countdown(10)
  }

  def countdown(n: Int): Unit = {
    //    for (i <- 0 to n){
    //      println(n - i)
    //    }
    (0 to n).reverse.foreach(println)
  }

  //  5、编写一个for循环,计算字符串中所有字母的Unicode代码（toLong方法）的乘积。举例来说，"Hello"中所有字符串的乘积为9415087488L
  @Test
  def test05(): Unit = {
    println(unicode("Hello"))
  }

  def unicode(str: String): Long = {
    var l: Long = 1
    for (i <- str) {
      l *= i.toLong
    }
    l
  }

  //  6、同样是解决前一个练习的问题，请用StringOps的foreach方式解决。
  @Test
  def test06(): Unit = {
    var l: Long = 1
    //    "Hello".foreach(i => l*=i)
    "Hello".foreach(l *= _)
    println(l)
  }

  //  7、编写一个函数product(s:String)，计算字符串中所有字母的Unicode代码（toLong方法）的乘积


  //  8、把7练习中的函数改成递归函数
  @Test
  def test08(): Unit = {
    println("Hello".drop(2)) //去掉第一个字符后剩下的
    println(product("Hello"))
  }

  def product(s: String): Long = {
    if (s.length == 1) return s.charAt(0).toLong
    //drop
    s.charAt(0).toLong * product(s.drop(1))
  }

  //  9、编写函数计算 ,其中n是整数，使用如下的递归定义:
  //  •	  = x* ,如果n是正数的话
  //  •	  = 1
  //  •	  = 1/ ,如果n是负数的话
  //  •	不得使用return语句

  @Test
  def test09(): Unit = {
    println(fun(2,-2))
  }

  def fun(x: Double, n: Int): Double = {
    if(n == 0) 1
    else if(n>0) x * fun(x,n-1)
    else 1 / fun(x,-n)
  }

}
