package com.demo.scala.akka.spark

/**
  * create by ZhengYingjie on 2019/2/22 15:49
  */
//work向master注册的信息
case class RegisterWorkerInfo(id:String,cpu:Int,ram:Int) {

}
//master保存的worker信息
case class WorkerInfo(id:String,cpu:Int,ram:Int){
  var lastHeartBeat:Long = _

  override def toString: String = Map("lastHeartBeat"->lastHeartBeat).mkString(",")
}

//master给worker发送的信息
case class RegisteredWorkerInfo()

//worker定时向自己发送的消息
case class SendHeartBeat()

//worker 向Master发送的定时心跳检测
case class HeartBeat(id:String)

//master 开启定期检测worker存活状态的定时任务
case class StartTimeOutWorker()

//master 检测worker存活状态的任务
case class RemoveTimeOutWorker()

