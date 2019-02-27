package com.demo.scala.design.Decorator.coffeebar.coffee

/**
  * create by ZhengYingjie on 2019/2/25 14:28
  */
//美式咖啡
class LongBlack extends Coffee {

  def this(price: Float, description: String)={
    this()
    this.setPrice(price)
    this.setDescription(description)
  }

}
