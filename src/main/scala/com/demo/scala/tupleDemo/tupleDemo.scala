package com.demo.scala.tupleDemo

/**
  * create by ZhengYingjie on 2019/1/29 17:22
  */
object tupleDemo {

  def main(args: Array[String]): Unit = {

    //创建
    val t1 = (2,"ds",1,32.1)

    //访问
    println("t1._1 = " + t1._1) //2

    println("t1._2 = " + t1.productElement(1)) //ds

    //遍历
    for(item <- t1.productIterator){
      print( item + "\t")
    }

  }
}
