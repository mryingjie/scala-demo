package com.demo.scala.akka.spark

import java.util
import java.util.UUID

import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * create by ZhengYingjie on 2019/2/21 19:41
  */
case class Worker(serverHost:String,serverPort:Int,serverName:String,serverSysName:String) extends Actor{

  var masterProxy:ActorSelection = _

  val id:String = UUID.randomUUID().toString

  override def preStart(): Unit = {
    masterProxy = context.actorSelection(s"akka.tcp://$serverSysName@$serverHost:$serverPort/user/$serverName")
    println(masterProxy)
  }

  override def receive: Receive = {
    case "start" => {
      println("Worker启动成功！！")
      println("向Master注册")
      masterProxy ! RegisterWorkerInfo(id,8,64)
    }
    case registed:RegisteredWorkerInfo =>{
      println("注册成功，Master返回信息{"+registed+"}")
      //开会执行定时心跳检测任务
      context.system.scheduler.schedule(3000 millis,3000 millis,self,SendHeartBeat)
    }
    case SendHeartBeat =>{
      println(s"id:${id}的worker执行心跳检测方法!!")
      masterProxy ! HeartBeat(id)
    }

  }

}

object Worker{

  def main(args: Array[String]): Unit = {

    val (clientHost,clientPort,clientName,serverHost,serverPort,serverName,serverSysName) =
      (args(0),args(1),args(2),args(3), args(4),args(5),"Spark-Master")

    val map:util.Map[String,Any] = new util.HashMap[String,Any]()
    map.put("akka.actor.provider","akka.remote.RemoteActorRefProvider")
    map.put("akka.remote.netty.tcp.hostname",clientHost)
    map.put("akka.remote.netty.tcp.port",clientPort)
    map.put("akka.actor.warn-about-java-serializer-usage",false)
    val config:Config = ConfigFactory.parseMap(map)

    val client = ActorSystem("Spark-Worker",config)
    val ref = client.actorOf(Props(Worker(serverHost,serverPort.toInt,serverName,serverSysName)),clientName)
    ref ! "start"
  }



}
