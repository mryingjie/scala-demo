package com.demo.scala.design.Decorator.coffeebar

import scala.beans.BeanProperty

/**
  * create by ZhengYingjie on 2019/2/25 14:14
  */
//
abstract class Drink {

  var description = ""

  private var price = 0.0F

  def setDescription(description:String): Unit ={
    this.description = description
  }

  def getDescription(): String ={
    this.description
  }

  def setPrice(price:Float): Unit ={
    this.price = price
  }

  def getPrice(): Float ={
    this.price
  }

  def cost(): Float

}
