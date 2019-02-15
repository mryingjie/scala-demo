package com.demo.scala.matchDemo

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/12 14:31
  */
class MatchDemo {


  /**
    * 匹配map
    */
  @Test
  def testMapMatch(): Unit ={
    val map = Map("0"->0,"1"->1,"2"->2)
    for((k,0) <- map){ //筛选出之为0的k
      println("K = " + k)
    }
  }

  /**
    * 匹配元组
    */
  @Test
  def testTupleMatch(): Unit ={
    val arrs = Array((0,1),(2,3),(3),(1,2,3),(0,3,1))

    for(item <- arrs){
      item match {
        case (0,_) => println(item + "匹配到 (0,_)")
        case (x,y) => println(item  + "匹配到 (x,y)")
        case (0,_,_) => println(item  + "匹配到 (0,_,_)")
        case _ => println("默认匹配模式")
      }
    }
  }


  /**
    * 匹配列表
    */
  @Test
  def testListMatch(): Unit ={
    val arrs = Array(List(0),List(88),List(0,2,1),List(2,1),List(),List(1),List(2,21,32,12))

    for(item <- arrs){
      item match{
        case List(x,y) => println(item  + "匹配到List(x,y) x = " + x + " y = " + y) //类似数组匹配 两个元素的集合
        case 1::Nil => println(item + " 匹配到 1::Nil") //只有一个元素1的集合
        case x:: y:: z => println(item + s"匹配到x::y::z x=$x y=$y z=$z" ) //3个或3元素以上的集合 z是除了前两个元素以外的剩余元素组成的集合
        case x :: y :: Nil => println(item + "匹配到 x :: y :: Nil") //有两个元素的集合
        case x :: Nil => println(item + "匹配到  x :: Nil") //只有一个元素的集合
        case 0 :: tail => println(item + "匹配到 0 :: tail" + "  tail = "+tail) //以0元素开头的集合
        case Nil => println("空集合")
      }

    }

  }

  /**
    * 匹配数组
    */
  @Test
  def testArrayMatch(): Unit ={

    val array = Array(Array(0),Array(1,0),Array(0,2,3),Array(2,2,3))

    for( arr <- array){
      val result = arr match {
        case _ if arr.length==1 => 0 //匹配守卫
        case Array(0, _*) => "0开头的集合"
        case Array(x, y) => Array(y, x) //交换元素
        case _ => "默认方式"
      }
      //类型匹配
      result match {
        case a : Array[Int] => println(a.mkString(","))
        case _ => println(result)
      }
    }


  }
}

class item{}
