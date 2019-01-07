package com.demo.scala

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/7 16:21
  */
class CycleTest {


  @Test
  def demo(): Unit ={

    var loop = true

    for(i <- 1 to 10 if loop){
      println("sss")
      if(i == 5 ){
        loop = false
      }
    }

  }
}
