package com.demo.scala.design.Decorator.coffeebar

import com.demo.scala.design.Decorator.coffeebar.coffee.LongBlack
import com.demo.scala.design.Decorator.coffeebar.decorator.{Milk, Sugar}

/**
  * create by ZhengYingjie on 2019/2/25 15:09
  */
object Client {

  def main(args: Array[String]): Unit = {

    val order1 = Sugar(Milk(new LongBlack(10.0f,"LongBlack")))

    println(s"order1 descprption{${order1.getDescription()}}")
    println(s"order1 price:${order1.cost()}")
    println("-------------------------------------------")

  }

}
