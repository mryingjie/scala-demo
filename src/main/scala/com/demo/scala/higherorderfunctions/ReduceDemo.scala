package com.demo.scala.higherorderfunctions

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/1 16:32
  */
class ReduceDemo {

  @Test
  def testSum(): Unit ={
    val list = List(2,4,6,8)
    val i1 = list.reduceLeft((a , b) => a + b)
    val i2 = list.reduce((a , b) => a + b)
    val i3 = list.reduceRight((a,b) => a+ b)
    println(i3)
  }


  @Test
  def getMin(): Unit ={
    val list = List(2,4,6,8)

    println(list.reduceLeft((a,b) => a.min(b)))
  }


}
