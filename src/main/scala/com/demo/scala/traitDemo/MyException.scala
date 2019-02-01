package com.demo.scala.traitDemo

/**
  * create by ZhengYingjie on 2019/1/22 9:56
  */
trait MyException extends Exception{

  def abMethon(): Double

  def acMethod(): Unit ={
    println(getMessage)
  }
}
