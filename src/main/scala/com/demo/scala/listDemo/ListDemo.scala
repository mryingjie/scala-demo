package com.demo.scala.listDemo

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/29 17:46
  */
class ListDemo {


  @Test
  def testList(): Unit ={
    val ints = List(2,3,2)
    println(ints)


    //空集合 Nil    case object Nil extends List[Nothing] {
    val nil = Nil
    println(nil)

  }

  @Test
  def testListAdd(){

    val list1 = List(4,5,"abc")
    val str = list1 + "2" //转成字符串List(4,5,"abc")2

//    list1(1) = "2"//不能修改 运行不通过

    println(list1(1)) // 5
    println("list1 = " +list1)
    println("str = "+str)

    val list2 = list1 :+ 6

    // List(4,5,"abc",6)
    println("list2 = "+list2)

    // List(6,4,5,"abc")
    val list3 = 6 +: list1
    println("list3 = " + list3)


    // List(6,4,5,"abc")
    val list4 = 6 :: list1
    println("list4 = " + list4)

    // List(6,4,5,"abc",4,5,"abc")
    val list5 = list4 ::: list1
    println("list5 = " + list5)

    // List(List(6,4,5,"abc"),4,5,"abc")
    val list6 = list4 :: list1
    println("list6 = " + list6)

    list1.foreach(x => print(x))
  }

  //删除不支持

  //修改 不支持 运行报错
  @Test
  def testListModefy(): Unit ={

    val list1 = List(4,5,4)
//    list1(2) = 23321
    println(list1)
  }

}
