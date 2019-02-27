package com.demo.scala.design.proxy.localcandymachine

/**
  * create by ZhengYingjie on 2019/2/26 9:19
  */
trait State extends Serializable{

  /**
    * 插入硬币
    */
  def insertCoin()

  /**
    * 返回硬币
    */
  def returnCoin()

  /**
    * 转动曲柄
    */
  def turnCrank()


  /**
    * 输出状态
    */
  def printState()


  /**
    * 返回状态名字
    */
  def getStateName():String


  /**
    * 分配状态  例如卖出一块糖后判断糖果机应该处于哪个状态
    */
  def dispense()
}
