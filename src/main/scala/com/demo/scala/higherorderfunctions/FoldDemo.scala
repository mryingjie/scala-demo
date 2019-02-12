package com.demo.scala.higherorderfunctions

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/1 17:21
  */
class FoldDemo {

  @Test
  def testFold(): Unit ={
    val list = List(2,4,6,8)
//    ((((5-2) - 4) - 6) - 8) = -15
    println(list.foldLeft(5)((a,b) => a - b )) //函数柯里化

    println(list.reduceLeft((a,b) => a - b ))

    println( (5 /: list)((a,b) => a - b )) //等价于上边的写法

    println((list :\ 5)((a,b) => a - b)) //右折叠
  }
}
