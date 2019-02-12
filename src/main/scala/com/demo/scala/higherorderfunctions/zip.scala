package com.demo.scala.higherorderfunctions

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/2/11 16:48
  */
class zip {

  @Test
  def testZip(): Unit ={
    val list1 = 1 to 6
    val list2 = 2 to 7

    println(list1.zip(list2))

  }

}
