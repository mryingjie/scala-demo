package com.demo.scala.partialFunc

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/13 15:37
  */
class PartialFuncDemo {


  @Test
  def test(): Unit ={
    //需求 将集合中的所有Int类型的元素+1 返回新的集合只包含处理后的结果元素
    val list = List(2,3,4,12,2.2,"abc")

    //方案一 过滤后map
    val result1 = list.filter(a => a.isInstanceOf[Int])
      .map(a => a.asInstanceOf[Int])
      .map(a => a +1)
    println(result1)

    //方案二 模式匹配会出现结果为（）的元素

  }

  @Test
  def testPartialFunc(): Unit ={
    val list = List(2,3,4,12,2.2,"abc")

    //定义偏函数
    val partialFun1 = new PartialFunction[Any,Int] {
      override def isDefinedAt(x: Any): Boolean = {
        x.isInstanceOf[Int]
      }

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int] + 1
      }

    }

    //原始方法
    println(list.collect(partialFun1))

    //第二种

    def partialFun2 : PartialFunction[Any,Int]={
      case x:Int => x +1
    }

    println(list.collect(partialFun2))

    //第三种
    println(list.collect({case x:Int => x+1}))

//    try {
//
//    }catch {
//      case ex: NullPointerException =>
//        println(ex)
//    }finally {
//
//    }
  }
}
