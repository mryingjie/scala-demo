package com.demo.scala.design.Decorator.coffeebar.coffee

/**
  * create by ZhengYingjie on 2019/2/25 14:23
  */
//意大利咖啡 在设计模式中充当ConcreteComponent
class Espresso() extends Coffee {

  def this(price: Float, description: String) = {
    this()
    //    使用住构造器
    super.setPrice(price)
    super.setDescription(description)
  }

}
