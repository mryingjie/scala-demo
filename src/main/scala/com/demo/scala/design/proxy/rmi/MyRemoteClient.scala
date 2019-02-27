package com.demo.scala.design.proxy.rmi

import java.rmi.Naming

/**
  * create by ZhengYingjie on 2019/2/26 14:48
  */
object MyRemoteClient{
  def main(args: Array[String]): Unit = {

    val service = Naming.lookup("rmi://127.0.0.1:9999/RemoteHello").asInstanceOf[MyRemoteImpl]

    val str = service.sayHello()

    println(str)

  }
}
