package com.demo.scala.extendsdemo

/**
  * create by ZhengYingjie on 2019/1/17 15:00
  */
abstract class Person {

  var inName:String

  var name: String = _
  var age: Int = _

  def sal() = 100.100

  def doSomthing():String

  override def toString = s"Person(name=$name, age=$age)"
}
