package com.demo.scala.higherorderfunctions

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/11 14:41
  */
class scan {


  @Test
  def testScan(): Unit ={

    //(3,4,5,6) => (5,2,-2,-7,-13)
    val i1 = (3 to 6).scanLeft(5)((a,b) => a - b)
    val i2 = (3 to 6).foldLeft(5)((a,b) => a - b)


    //(3,4,5,6) => (3,0,4,1,5)
    val i3 = (3 to 6).scanRight(5)((a,b) => a -b)
    val i4 = (3 to 6).foldRight(5)((a,b) => a -b)
    println(i1)

    println(i2)


    println(i3)

    println(i4)
  }

}
