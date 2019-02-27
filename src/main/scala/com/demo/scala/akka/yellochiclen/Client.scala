//package com.demo.scala.akka.spark
//
//import java.util
//
//import akka.actor.{Actor, ActorSelection, ActorSystem, Props}
//import com.demo.scala.akka.yellochiclen.{ClientMessage, ServerMessage}
//import com.typesafe.config.{Config, ConfigFactory}
//
//import scala.io.StdIn
//
///**
//  * create by ZhengYingjie on 2019/2/21 19:41
//  */
//case class Client(serverHost:String,serverPort:Int,serverName:String,serverSysName:String) extends Actor{
//
//  var serverActorRef:ActorSelection = _
//
//  override def preStart(): Unit = {
//    serverActorRef = context.actorSelection(s"akka.tcp://$serverSysName@$serverHost:$serverPort/user/$serverName")
//    println(serverActorRef)
//  }
//
//  override def receive: Receive = {
//    case "start"=>println("客户端启动成功！")
//    case ClientMessage(msg) => {
//      serverActorRef ! ClientMessage(msg)
//    }
//    case ServerMessage(msg) =>{
//      println(s"server:$msg")
//    }
//  }
//
//}
//
//object Client{
//
//  def main(args: Array[String]): Unit = {
//
//    val (clientHost,clientPort,serverHost,serverPort,serverName,serverSysName) = ("127.0.0.1",9990,"127.0.0.1",9999,
//      "YelloChickenServer","server")
//
//    val map:util.Map[String,Any] = new util.HashMap[String,Any]()
//    map.put("akka.actor.provider","akka.remote.RemoteActorRefProvider")
//    map.put("akka.remote.netty.tcp.hostname",clientHost)
//    map.put("akka.remote.netty.tcp.port",clientPort)
//    map.put("akka.actor.warn-about-java-serializer-usage",false)
//    val config:Config = ConfigFactory.parseMap(map)
//
//    val client = ActorSystem("client1",config)
//    val ref = client.actorOf(Props(Client(serverHost,serverPort,serverName,serverSysName)),"QQ")
//    ref ! "start"
//
//    while (true){
//      Thread sleep 100
//      print("请输入：")
//      val line = StdIn.readLine
//      if(line.equals("quit")) System.exit(0)
//      Thread sleep 100
//      ref ! ClientMessage(line)
//    }
//
//  }
//
//
//
//}
