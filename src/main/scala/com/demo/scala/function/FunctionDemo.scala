package com.demo.scala.function

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/8 11:46
  */
class FunctionDemo {


  @Test
  def testSum(): Unit ={

    println(sum(1,4,6,3,5))
  }

  //可变参数 至少一个参数
  def sum(n1: Int, args: Int*): Int = {
    var sum = n1
    for (nu <- args) {
      sum += nu
    }
    sum
  }


  @Test
  def testDefaultParmater(): Unit = {
    //    println(defaultParamter("marry"))  报错
    //    println(defaultParamter(v1 = "marry")) 报错
    println(defaultParamter(v2 = "marry"))
  }

  def defaultParamter(v1: String = "tom", v2: String): String = {
    v1 + v2
  }


  @Test
  def main2(): Unit = {

    val fun = test _
    fun(4)

  }

  def test(n: Int): Unit = {
    if (n > 2) {
      test(n - 1)
    }
    println(n)
  }


  @Test
  def main() = {
    val res = getResult(1, 2, "/")
    println(s"res = $res")
  }

  def getResult(n1: Int, n2: Int, str: String) = {
    if ("+" eq str) {
      n1 + n2
    } else if ("-" eq str) {
      n1 - n2
    } else {
      null
    }
  }

}
