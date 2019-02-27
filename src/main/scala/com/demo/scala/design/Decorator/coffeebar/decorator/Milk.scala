package com.demo.scala.design.Decorator.coffeebar.decorator

import com.demo.scala.design.Decorator.coffeebar.Drink

/**
  * create by ZhengYingjie on 2019/2/25 14:52
  */
//牛奶配料
case class Milk(drink: Drink) extends Decorator(drink) {

  this.setDescription("milk")

  this.setPrice(1.5f)

}
