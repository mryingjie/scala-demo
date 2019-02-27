package com.demo.scala.design.observer

/**
  * create by ZhengYingjie on 2019/2/25 20:07
  */
class SnnaCurrentConditions extends Observer {
  private var mTemperature: Float = _

  private var mPressure: Float = _

  private var mHumidity: Float = _

  def update(o: Observable, arg: scala.Any): Unit = {
    val messagge = arg match {
      case m@Messagge(_, _, _) => m
      case _ => throw new Exception("信息协议异常！！！")
    }
    this.mTemperature = messagge.mHumidity
    this.mPressure = messagge.mPressure
    this.mHumidity = messagge.mHumidity
    display()
  }

  def display() = {
    println(toString)
  }


  override def toString = s"新浪网官方公告板(mTemperature:$mTemperature, \nmPressure:$mPressure," +
    s"\nmHumidity:$mHumidity)"

}
