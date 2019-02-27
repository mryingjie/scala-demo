package com.demo.scala.design.observer

import java.util.Observer


/**
  * create by ZhengYingjie on 2019/2/25 19:36
  */
trait Observable {


  def addObserver(o:Observer)

  def removeObserver(o:Observer)

  def notifyAll(arg:Object)

  def changeData(arg:Object)

}
