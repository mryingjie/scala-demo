package com.demo.scala.design.proxy.localcandymachine

import java.util.Random

/**
  * create by ZhengYingjie on 2019/2/26 9:43
  */
class HasCoin extends State {

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
    println("You have inserted a coin!!!")
  }

  /**
    * 返回硬币
    */
  override def returnCoin(): Unit = {
    println("coin return!")
    //如果在有coin的状态,执行了returnCoin,那么糖果机又进入了readState
    mCandyMachin.setState(mCandyMachin.mOnReadyState)
  }

  /**
    * 转动曲柄
    */
  override def turnCrank(): Unit = {
    println("crank turn...!(转动曲柄)")
    //如果返回一个偶数就再奖励一块糖
    val rankwinner = new Random().nextInt(10)

    if(rankwinner % 2 == 0){
      println("your are winner!!!")
      mCandyMachin.setState(mCandyMachin.mWinnerState)
    }else{
      println("your are not winner!!!")
      mCandyMachin.setState(mCandyMachin.mSoldState)
    }

    mCandyMachin.dispense()
  }

  /**
    * 输出状态
    */
  override def printState(): Unit = {
    println("*****HAS_COIN*****")
  }

  /**
    * 返回状态名字
    */
  override def getStateName(): String = {
     "*****HAS_COIN*****"
  }

  /**
    * 分配状态  例如卖出一块糖后判断糖果机应该处于哪个状态
    */
  override def dispense(): Unit = {

  }
}
