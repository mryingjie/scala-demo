package com.demo.scala.ClassDemo

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/14 9:50
  */
class Cat {
  var name = null //Null类型
  var address = "北京" // String类型
  var age:Int = _ //0
  var master: String = _ //null
  var height: String = null

  @Test
  def testCat(): Unit ={
    val cat = new Cat
    println(cat.toString)
  }


  override def toString = s"Cat(name=$name, address=$address, age=$age, master=$master, height=$height)"
}
