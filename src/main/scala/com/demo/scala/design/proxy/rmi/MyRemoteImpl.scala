package com.demo.scala.design.proxy.rmi

import java.rmi.registry.LocateRegistry
import java.rmi.{Naming, RemoteException}
import java.rmi.server.UnicastRemoteObject

/**
  * create by ZhengYingjie on 2019/2/26 14:48
  */
class MyRemoteImpl extends UnicastRemoteObject with MyRemote {

  @throws(classOf[RemoteException])
  override def sayHello(): String = {
    "Hello World!!"
  }
}

//完成对服务的注册
object MyRemoteImpl {

  def main(args: Array[String]): Unit = {
    val service: MyRemote = new MyRemoteImpl
    //把服务绑定到9999端口 第一种
    //LocateRegistry.createRegistry(9999)
    //Naming.rebind("RemoteHello",service)

    //第二种
    Naming.rebind("rmi://127.0.0.1:23232/RemoteHello", service)
    println("远程服务开启，地址：rmi:127.0.0.1:23232/RemoteHello")
  }
}
