package com.demo.scala.design.proxy.localcandymachine

import scala.collection.mutable.ListBuffer

/**
  * create by ZhengYingjie on 2019/2/26 10:37
  */
class Monitor {

  //监控本地多台机器
  private val candyMachinelst:ListBuffer[CandyMachine] = ListBuffer()


  def addMachine(mCandyMachine:CandyMachine)={
    candyMachinelst.append(mCandyMachine)
  }

  //输出该监控器管理的各个糖果机的信息
  def report ={
    for(mCandyMachine <- this.candyMachinelst){
      println("---------------------------------------")
      println("Machine Loc:"+mCandyMachine.getLocation())
      println("Machine Candy count:"+mCandyMachine.getCount())
      println("Machine State:"+ mCandyMachine.getState().getStateName())
    }
  }

}
