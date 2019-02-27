package com.demo.scala.design.Decorator.coffeebar.coffee

import com.demo.scala.design.Decorator.coffeebar.Drink

/**
  * create by ZhengYingjie on 2019/2/25 14:21
  * Drink和各个咖啡之间的缓冲层
  * 为了扩展其他饮品 例如果汁等
  */
class Coffee extends Drink{
  override def cost(): Float = {
    super.getPrice()
  }
}
