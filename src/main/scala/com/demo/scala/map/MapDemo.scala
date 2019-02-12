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
    val map = map01_1 + ("003" -> "003")
    //按添加顺序存储
    val map01_2 =  Map("01" -> "abc","02" -> 2,("03","abcd"))
    println("immutable.HashMap =" + map01_1)
    println("immutable.HashMap =" + map)
    println("immutable.Map =" + map01_2)

    //可变Map
    //不按添加顺序存储
    val map02 = mutable.Map("01" -> "abc","02" -> 2,("03","abcd"),"a" -> 121)
    val map03 = mutable.HashMap("01" -> "abc","02" -> 2,("03","abcd"),"a" -> 121)
    map02 += ("003" -> "003")
//    map02 + ("003" -> "003") //创建新的map
    println("mutable.map ="+map02)
    println("mutable.HashMap ="+map03)

    println("***************获取元素*********************")


    val value01 = map02.get("01").get

    println(map02("01"))

    val unit = map02.getOrElse("001","001")
    println(unit)
  }

  //添加
  @Test
  def add(): Unit ={
    val map = mutable.Map("01" -> "abc","02" -> 2,("03","abcd"),"a" -> 121)

    map("01") = "000001" //有则更新，无则添加
    map("04") = "000004"

    map += ("a" -> "s","b" -> "bbbbb")

    println(map)

    //删除
    map -= "b"
    println(map)
    map -= ("a","01")
    println(map)



  }

  //遍历
  @Test
  def testTraversing(): Unit ={
    val map = mutable.Map("01" -> "abc","02" -> 2,("03","abcd"),"a" -> 121)

    //遍历为元组
    for(tuple <- map){
      println("tuple = "+ tuple + " key = " + tuple._1 + "value = " + tuple._2)
    }
    println("***************************************" * 2)
    //直接遍历
    for((k,v) <- map){
      println(" k = " + k + s"v = $v")
    }

    println("*" * 20)
    for( k <- map.keys){
      println( k )
    }
    println("*" * 20)
    for( v <- map.values){
      println( v )
    }
  }

}
