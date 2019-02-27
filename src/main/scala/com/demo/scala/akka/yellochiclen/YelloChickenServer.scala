package com.demo.scala.akka.yellochiclen

import java.time.LocalDateTime
import java.util

import akka.actor.{Actor, ActorSystem, Props}
import com.typesafe.config.{Config, ConfigFactory}

/**
  * create by ZhengYingjie on 2019/2/21 16:45
  */
class YelloChickenServer extends Actor{
  override def receive: Receive = {
    case "start" => println("服务器启动成功！！！")
    case ClientMessage(msg)=>{
      println("收到来自"+sender().toString()+"的消息："+msg)
      msg match{
        case "小爱同学" => {
          sender() ! ServerMessage("哎！")
        }
        case "几点了？" =>{
          sender() ! ServerMessage(LocalDateTime.now().toString)
        }
        case _ =>{
          sender() ! ServerMessage("what?")
        }
      }
    }
  }
}

object YelloChickenServer {
  def main(args: Array[String]): Unit = {

//    val config = ConfigFactory.parseString(
//      """akka.actor.provider="akka.remote.RemoteActorRefProvider"
//        |akka.remote.netty.tcp.hostname="127.0.0.1"
//        |akka.remote.netty.tcp.port=9999""".stripMargin)
    val port = 9999
    val map:util.Map[String,Any] = new util.HashMap[String,Any]()
    map.put("akka.actor.provider","akka.remote.RemoteActorRefProvider")
    map.put("akka.remote.netty.tcp.hostname","127.0.0.1")
    map.put("akka.remote.netty.tcp.port",port)
    map.put("akka.actor.warn-about-java-serializer-usage",false)
    val config:Config = ConfigFactory.parseMap(map)

    val server = ActorSystem("server",config)
    val serverRef = server.actorOf(Props[YelloChickenServer],"YelloChickenServer")

    serverRef ! "start"

  }
}
