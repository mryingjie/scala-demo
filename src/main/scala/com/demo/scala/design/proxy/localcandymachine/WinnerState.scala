package com.demo.scala.design.proxy.localcandymachine

/**
  * create by ZhengYingjie on 2019/2/26 10:33
  */
class WinnerState extends State{


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
    println("please wait! we are giving you a candy")
  }

  /**
    * 返回硬币
    */
  override def returnCoin(): Unit = {

  }

  /**
    * 转动曲柄
    */
  override def turnCrank(): Unit = {

  }

  /**
    * 输出状态
    */
  override def printState(): Unit = {
    println("*****WinnerState*****")
  }

  /**
    * 返回状态名字
    */
  override def getStateName(): String = {
    "*****WinnerState*****"
  }

  /**
    * 分配状态  例如卖出一块糖后判断糖果机应该处于哪个状态
    */
  override def dispense(): Unit = {
    //糖果数量减2
    mCandyMachin.releaseCandy(2)
    if(mCandyMachin.getCount > 0){
      mCandyMachin.setState(mCandyMachin.mOnReadyState)
    }else{
      //没糖了
      println("Oo,out of candies")
      mCandyMachin.setState(mCandyMachin.mSoldOutState)
    }
  }
}
