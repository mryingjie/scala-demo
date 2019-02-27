package com.demo.scala.design.proxy.localcandymachine

/**
  * create by ZhengYingjie on 2019/2/26 10:17
  * 处于销售中的状态(正在出糖)
  */
class SoldState extends State {

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
  override def turnCrank(): Unit ={
    println("we are giving you a candy,please wait a minuite!!!")
  }
  /**
    * 输出状态
    */
  override def printState(): Unit = {
    println("****SoldState****")
  }

  /**
    * 返回状态名字
    */
  override def getStateName(): String = {
    "****SoldState****"
  }

  /**
    * 分配状态  例如卖出一块糖后判断糖果机应该处于哪个状态
    */
  override def dispense(): Unit = {
    //糖果数量减一
    mCandyMachin.releaseCandy()
    if(mCandyMachin.getCount > 0){
      mCandyMachin.setState(mCandyMachin.mOnReadyState)
    }else{
      //没糖了
      println("Oo,out of candies")
      mCandyMachin.setState(mCandyMachin.mSoldOutState)
    }
  }
}
