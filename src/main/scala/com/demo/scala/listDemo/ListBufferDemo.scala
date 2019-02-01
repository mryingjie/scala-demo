package com.demo.scala.listDemo

import org.junit.Test

import scala.collection.mutable.ListBuffer

/**
  * create by ZhengYingjie on 2019/1/31 10:50
  */
class ListBufferDemo {


  @Test
  def  testListBufferAdd(){

    val list01 = ListBuffer(1,2,3,"sa")

    //添加
    list01.append("s",3,1)
    println("list01 = " + list01)
    val list0 = list01 += 5 += 6 //不会创建新的ListBuffer
    println(list0 == list01) //true
    println("list01 = " + list01)
    val buffer01 = list01 :+ "a" //创建新的ListBuffer并添加a
    val buffer02 = list01 ++ "a" //创建新的ListBuffer并添加a
    println(buffer01 == list01) //false
    println(buffer02 == list01) //false
    println("buffer01 = "+ buffer01)
    println("buffer02 = "+ buffer02)
    println("list01  =" + list01)

    list01 ++= buffer02 //将buffer02 的数据放入list01中
  }

  //删除
  @Test
  def testListBufferRemove(): Unit ={
    val list01 = ListBuffer(1,2,3,"sa")
//    val list = list01.result() //可变转不可变
//    val buffer = list.toBuffer //不可变转可变
    list01.remove(0)

    println(list01)
  }

  //修改
  @Test
  def testListBufferModify(): Unit ={
    val list01 = ListBuffer(1,2,3,"sa")
    list01(2) = 87
    println(list01)
  }

  //查
  @Test
  def testListBufferCheck(): Unit ={
    val list01 = ListBuffer(1,2,3,"sa")
    println(list01(2))
  }


}
