package com.demo.scala.design.observer


/**
  * create by ZhengYingjie on 2019/2/25 19:05
  * 气象局的公告板
  */
class CurrentConditions extends Observer {

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


  override def toString = s"气象局官方公告板(mTemperature:$mTemperature, \nmPressure:$mPressure," +
    s"\nmHumidity:$mHumidity)"

}
