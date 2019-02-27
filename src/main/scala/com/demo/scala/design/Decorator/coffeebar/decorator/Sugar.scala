package com.demo.scala.design.Decorator.coffeebar.decorator

import com.demo.scala.design.Decorator.coffeebar.Drink

/**
  * create by ZhengYingjie on 2019/2/25 14:58
  */
case class Sugar(drink:Drink) extends Decorator(drink){

  this.setPrice(1.0F)
  this.setDescription("sugar")

}
