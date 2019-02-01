package com.demo.scala.map

import org.junit.Test

import scala.collection.immutable.HashMap
import scala.collection.mutable


/**
  * create by ZhengYingjie on 2019/1/31 17:15
  */
class MapDemo {

  @Test
  def testMapCreate(): Unit ={

    //不可变Map
    //不按添加顺序存储
    val map01_1 =  HashMap("01" -> "abc","02" -> 2,("03","abcd"),"a" -> 121)
    //按添加顺序存储
    val map01_2 =  Map("01" -> "abc","02" -> 2,("03","abcd"))
    println("immutable.HashMap =" + map01_1)
    println("immutable.Map =" + map01_2)

    //可变Map
    //不按添加顺序存储
    val map02 = mutable.Map("01" -> "abc","02" -> 2,("03","abcd"),"a" -> 121)

    println("mutable.map ="+map02)

    println("***************获取元素*********************")


    val value01 = map02.get("01").get

    println(map02("01"))

    val unit = map02.getOrElse("001","001")
    println(unit)


  }

}
