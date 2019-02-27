package com.demo.scala.design.proxy.localcandymachine

import scala.beans.BeanProperty

/**
  * create by ZhengYingjie on 2019/2/26 10:43
  */
class CandyMachine extends State{


  @BeanProperty
  var location:String = _

  @BeanProperty
  var count :Int = _

  @BeanProperty
  var state :State = _

  val mHasCoin :State = new HasCoin(this)

  val mOnReadyState:State = new OnReadyState(this)

  val mSoldState:State = new SoldState(this)

  val mSoldOutState:State = new SoldOutState(this)

  val mWinnerState :State = new WinnerState(this)

  def this(location:String,initCount:Int){
    this()
    this.count = initCount
    this.location = location
    this.state = mOnReadyState
  }

  def releaseCandy() = this.count -= 1
  def releaseCandy(no:Int) = this.count -= no

  /**
    * 返回硬币
    */
  override def returnCoin(): Unit = {
    state.returnCoin()
  }

  /**
    * 转动曲柄
    */
  override def turnCrank(): Unit = {
    state.turnCrank()
  }

  /**
    * 输出状态
    */
  override def printState(): Unit = {
    state.printState()
  }

  /**
    * 返回状态名字
    */
  override def getStateName(): String = {
    state.getStateName()
  }

  /**
    * 分配状态  例如卖出一块糖后判断糖果机应该处于哪个状态
    */
  override def dispense(): Unit = {
    state.dispense()
  }

  /**
    * 插入硬币
    */
  override def insertCoin(): Unit = {
    state.insertCoin()
  }
}
