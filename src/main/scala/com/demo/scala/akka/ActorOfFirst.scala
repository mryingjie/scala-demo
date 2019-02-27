package com.demo.scala.akka

import akka.actor.{Actor, ActorSystem, Props}
import com.demo.scala.project.bean.Customer


/**
  * create by ZhengYingjie on 2019/2/20 20:18
  */
class ActorOfFirst extends Actor{
  override def receive: Receive = {
    case "exits" => {
      println("退出指令")
      context.stop(self)
      context.system.terminate()
    }
    case str:String => println(s"收到字符串：$str")
    case i:Int => println(s"收到整型：$i")
    case x => println(s"收到未知类型消息：$x")
  }
}

object client{

  def main(args: Array[String]): Unit = {

    val actorA = ActorSystem("actorA")
    val refA = actorA.actorOf(Props[ActorOfFirst],"refA")
    refA ! "dsadsa"
    refA ! 23
    refA ! Customer("sda",2,"132131",32.2)
    refA ! "exits"
  }
}
