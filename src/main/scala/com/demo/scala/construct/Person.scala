package com.demo.scala
package construct

import java.util

import org.junit.Test

import scala.beans.BeanProperty
import scala.collection.mutable

/**
  * create by ZhengYingjie on 2019/1/14 17:52
  */
class Person() extends  App {

  @BeanProperty
  var name: String = _
  var age:Int = _

  @Test
  def test01(): Unit ={
    val dog = new Dog("jack",18)
    println(dog.age)
    println(name)
    println(method())
    val map = new mutable.HashMap()
    val intToString = new
        util.HashMap[Int,String]()
  }

  def method(): Any ={
    return
  }

//  def setName(name:String): Unit ={
//    this.name = "name"
//  }

  override def toString = s"Person(name=$name, age=$age)"
}

