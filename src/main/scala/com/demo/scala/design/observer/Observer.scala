package com.demo.scala.design.observer

/**
  * create by ZhengYingjie on 2019/2/25 19:52
  */
trait Observer {

  def update(o: Observable, arg: scala.Any)

}
