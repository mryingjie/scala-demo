package com.demo.scala.generic

import java.lang

/**
  * create by ZhengYingjie on 2019/2/27 9:39
  * 编写一个通用的类，可以进行Int之间、Float之间、等实现了Comparable接口的值直接的比较
  */
object UpperBounds {

  def main(args: Array[String]): Unit = {


    //运行不通过 需要改为以下的格式
//    val nu = new Compares(2,3).max()
//    println(nu)


    val t= new Compares(Integer.valueOf(10),Integer.valueOf(20)).max()
    println(t)

    val float = new Compares[lang.Float](10.0f,20.0f).max() //隐式转换

    println(float)
  }

}


class Compares[T <: Comparable[T]](obj1: T, obj2: T) {

  def max() = {
    if(obj1.compareTo(obj2)>0) obj1 else obj2
  }

}