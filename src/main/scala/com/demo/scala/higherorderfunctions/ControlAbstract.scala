package com.demo.scala.higherorderfunctions

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/14 17:51
  */
class ControlAbstract {


  @Test
  def test(): Unit ={
    //使用控制抽象自己实现一个wile循环的语法结构
    var x = 10
    until(x >0){
      x -= 1
      println(x)
    }

  }

  def until(contdition: => Boolean)(block : => Unit): Unit ={
    if(contdition){
      block
      until(contdition){
        block
      }
    }
  }


}
