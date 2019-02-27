package com.demo.scala.project.bean

/**
  * create by ZhengYingjie on 2019/2/20 14:50
  */
class Customer {

  var name:String = _

  var age:Int = _

  var phone:String = _

  var amount:Double = _

  def this(name:String,age:Int,phone:String,amount:Double){
    this()
    this.name = name
    this.age = age
    this.phone = phone
    this.amount = amount
  }

  override def toString = s"$name \t\t $age \t\t $phone \t\t $amount)"
}

object Customer{
  def apply(name:String,age:Int,phone:String,amount:Double): Customer = new Customer(name,age,phone,amount)
}
