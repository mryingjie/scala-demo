package com.demo.scala.design.Decorator.coffeebar.decorator

import com.demo.scala.design.Decorator.coffeebar.Drink

/**
  * create by ZhengYingjie on 2019/2/25 14:33
  */
abstract class Decorator(drink: Drink) extends Drink{

  private val drinkObj:Drink = drink


  override def cost(): Float = {
    drinkObj.cost() + super.getPrice()
  }


  override def getDescription(): String = {
    this.drinkObj.getDescription()+  "&&" + super.getDescription()
  }
}
