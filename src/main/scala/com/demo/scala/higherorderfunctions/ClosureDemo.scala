package com.demo.scala.higherorderfunctions

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/14 10:44
  */
class ClosureDemo {

  /**
    * 编写一个函数 makeSuffix(suffix: String)  可以接收一个文件后缀名(比如.jpg)，并返回一个闭包
    * 调用闭包，可以传入一个文件名，
    * 如果该文件名没有指定的后缀(比如.jpg) ,则返回 文件名.jpg ,
    * 如果已经有.jpg后缀，则返回原文件名。
    */

  @Test
  def test(): Unit ={

    val f = makeSuffix(".jpg")
    println(f("cat.jpg"))
    println(f("dog"))


  }

  def makeSuffix(suffix:String)={
    (fileName:String) => {
      if(fileName.endsWith(suffix)) fileName
      else fileName + suffix
    }
  }

}
