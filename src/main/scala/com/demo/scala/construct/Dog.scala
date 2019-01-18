package com.demo.scala.construct

import org.junit.Test

import scala.beans.BeanProperty

/**
  * create by ZhengYingjie on 2019/1/14 18:19
  */
class Dog private(var inName:String){
  @BeanProperty var name: String = inName
  var age: Int = _


  def this(name:String,age:Int){
    this("jack")
    this.age = age

  }


  override def toString = s"Dog(name=$name, age=$age, inName=$inName)"
}
