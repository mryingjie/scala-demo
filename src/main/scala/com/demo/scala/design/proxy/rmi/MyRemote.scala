package com.demo.scala.design.proxy.rmi

import java.rmi.{Remote, RemoteException}

/**
  * create by ZhengYingjie on 2019/2/26 14:43
  * 接口文件，该文件会给远程端和本地端使用
  */
trait MyRemote extends Remote{

  @throws(classOf[RemoteException])
  def sayHello():String

}
