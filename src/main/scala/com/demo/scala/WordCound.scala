package com.demo.scala
import org.junit._

import scala.annotation.strictfp

/**
  * create by ZhengYingjie on 2019/2/23 15:49
  * 模拟MapMeduce的执行过程
  */
@strictfp
class WordCound {

  val strs = List("super hero java scala hadoop hadoop" , "hadoop java" , "java scala")

  @Test
  def test(): Unit ={
    //扁平化 =>List(super, hero, java, scala, hadoop, hadoop, hadoop, java, java, scala)
    val strings = strs.flatMap(_.split(" "))
    println("扁平化=>"+strings)

    //map List((super,1), (hero,1), (java,1), (scala,1), (hadoop,1), (hadoop,1), (hadoop,1), (java,1), (java,1),
    // (scala,1))
    val tuples = strings.map((_,1))
    println("map=>"+tuples)

    //分组  Map(super -> List((super,1)), java -> List((java,1), (java,1), (java,1)), hadoop -> List((hadoop,1), (hadoop,1), (hadoop,1)), hero -> List((hero,1)), scala -> List((scala,1), (scala,1)))
    val stringToTuples = tuples.groupBy(_._1)
    println("分组=>"+stringToTuples)

    //统计 reduce
    val stringToInt = stringToTuples.map(x=>(x._1,x._2.size))
    println("统计=>"+stringToInt)

    //排序
    val res = stringToInt.toList.sortBy(_._2)
    println("排序=>"+res)
  }

}
