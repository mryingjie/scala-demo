package com.demo.scala.design.proxy.localcandymachine

/**
  * create by ZhengYingjie on 2019/2/26 11:06
  */
object Client {

  def main(args: Array[String]): Unit = {

    val mMonitor = new Monitor

    val machine01 = new CandyMachine("北京-海淀区", 6)
    mMonitor.addMachine(machine01)

    val machine02 = new CandyMachine("北京-昌平区",4)
    machine02.insertCoin()
    mMonitor.addMachine(machine02)


    val machine03 = new CandyMachine("北京-朝阳区", 14)
    machine03.insertCoin()
    machine03.turnCrank()
    mMonitor.addMachine(machine03)

    mMonitor.report


  }

}
