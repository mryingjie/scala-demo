package com.demo.scala.extendsdemo

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/17 15:02
  */
class Student extends Person {

  var leave:Int = _

  override def toString: String = s"Student(name=$name,age=$age,leave=$leave)"

  override val sal:Double = 100.200

  @Test
  def test(): Unit ={
    val student:Person = new Student
    println(student.sal)
    student.inName = "ssss"
    println(student.inName)
  }

  override var inName: String = _

  override def doSomthing(): String = {
    "sds"
  }
}
