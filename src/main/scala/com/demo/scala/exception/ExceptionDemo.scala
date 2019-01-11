package com.demo.scala.exception

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/11 17:39
  */
class ExceptionDemo {


  @Test
  def testMyException(): Unit ={
//    myexception()
    myExcpetion2()
  }

  def myexception(): Unit ={
    throw new Exception("ssss")
  }


  @throws(classOf[RuntimeException])
  def myExcpetion2(): Int ={
    2/0
  }

}
