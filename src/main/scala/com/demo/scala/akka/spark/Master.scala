package com.demo.scala.akka.spark

import java.util

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.mutable
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * create by ZhengYingjie on 2019/2/22 16:07
  */
class Master extends Actor {

  val workerInfos = mutable.Map[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" => {
      println("Master 启动成功！！！")
      //开启定时任务
      self ! StartTimeOutWorker()
    }
    case RegisterWorkerInfo(id, cpu, ram) => {
      workerInfos += (id -> WorkerInfo(id, cpu, ram))
      println("worker regist message{" + workerInfos(id) + "}")
      sender ! new RegisteredWorkerInfo
    }
    case HeartBeat(id) => {
      println(s"收到id：${id}的worker发送的心跳检测")
      val info = workerInfos(id)
      info.lastHeartBeat = System.currentTimeMillis()
      println(workerInfos)
    }
    case StartTimeOutWorker() => {
      println("开启查看过期Worker的定时任务！！")
      context.system.scheduler.schedule(0 millis, 9000 millis, self, RemoveTimeOutWorker())
    }
    case RemoveTimeOutWorker() => {
      val workers = workerInfos.values
      val now = System.currentTimeMillis()
      workers.filter(now - _.lastHeartBeat > 5000).foreach(worker =>workerInfos.remove(worker.id))
      println(s"当前worker存活数：${workerInfos.size}")
    }
  }
}

object Master {
  def main(args: Array[String]): Unit = {

    val host  = args(0)
    val port = args(1).toInt
    val serverName = args(2)
    val map: util.Map[String, Any] = new util.HashMap[String, Any]()
    map.put("akka.actor.provider", "akka.remote.RemoteActorRefProvider")
    map.put("akka.remote.netty.tcp.hostname", host)
    map.put("akka.remote.netty.tcp.port", port)
    map.put("akka.actor.warn-about-java-serializer-usage", false)
    val config: Config = ConfigFactory.parseMap(map)

    val server = ActorSystem("Spark-Master", config)
    val serverRef = server.actorOf(Props[Master], serverName)

    serverRef ! "start"
  }
}
