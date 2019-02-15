package com.demo.scala

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/15 10:15
  */
class RecursiveDemo {


  /**
    * 递归求和
    */
  @Test
  def testRecursiceSum(): Unit ={

////    求999999999以内的整数和
//    val result = recursiceSum(1000000000);
//    println(result)

//    var sum:BigInt = 0
//    for(i <- 0 to 1000000000){
//      sum += i
//    }
//    println(sum)
  }

  def recursiceSum(l: BigInt):BigInt = {
    if(l<=1){
      l
    }
    recursiceSum(l,0);
  }

  def recursiceSum(l:BigInt,sum:BigInt): BigInt ={
    if(l==0)sum
    else recursiceSum(l-1,sum+l)
  }


  /**
    * 递归求集合中的最大值
    */
  @Test
  def testRecursiceListMax(): Unit ={
    val list = List(2,3,132,43,-231,31)
    val res:Int = getListMax(null)

    println(list.tail)
    println(res)
  }
  def getListMax(list: List[Int]): Int = {
    if(list == null){
      throw new NullPointerException("list is null")
    }
    if(list.length == 0){
      throw new Exception("list.length = 0")
    }
    if(list.length == 1){
      return list(0)
    }
    if(list.head > getListMax(list.tail)) list.head
    else getListMax(list.tail)
  }



  /**
    * 递归反转字符换
    */
  @Test
  def testReverseStr(): Unit ={
    val str = "Hello"
    val res : String = reverseStr(str)
    println(res)
  }
  def reverseStr(str: String): String = {
    if(str.length == 1){
      str
    }else{
      reverseStr(str.tail) + str.head
    }
  }

  /**
    * 递归求阶乘
    */

  def getFactoryial(n : Int): Int ={
    if(n == 1) n
    else getFactoryial(n-1) * n
  }

  @Test
  def factoryial(): Unit ={
    println(getFactoryial(4))
  }


}
