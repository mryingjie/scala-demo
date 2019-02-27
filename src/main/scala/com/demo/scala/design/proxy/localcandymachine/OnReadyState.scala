package com.demo.scala.design.proxy.localcandymachine

/**
  * create by ZhengYingjie on 2019/2/26 10:00
  */
class OnReadyState extends State{

  @transient private var mCandyMachin:CandyMachine = _

  //观察的是这个糖果机的状态（本地）
  def this(mCandyMachin:CandyMachine){
    this()
    this.mCandyMachin = mCandyMachin
  }

  /**
    * 插入硬币
    */
  override def insertCoin(): Unit = {
    println("you have inserted a coin , next, please turn crank!")
    //同时给糖果机设置有硬币的状态
    this.mCandyMachin.setState(mCandyMachin.mHasCoin)
  }

  /**
    * 返回硬币
    */
  override def returnCoin(): Unit = {
    println("you have no coin inserted to machine!!!")
  }

  /**
    * 转动曲柄
    */
  override def turnCrank(): Unit = {
    println("please insert a coin into machin first!!")
  }

  /**
    * 输出状态
    */
  override def printState(): Unit = {
    println("******ON_READY*****")
  }

  /**
    * 返回状态名字
    */
  override def getStateName(): String = {
    "******ON_READY*****"
  }

  /**
    * 分配状态  例如卖出一块糖后判断糖果机应该处于哪个状态
    */
  override def dispense(): Unit = {

  }
}
