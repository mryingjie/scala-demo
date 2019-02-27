package com.demo.scala.akka

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * create by ZhengYingjie on 2019/2/21 14:04
  */
object AkkaCommunication {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem()
    val refB = system.actorOf(Props[ActorB])
    val refA = system.actorOf(Props(ActorA(refB)))
    refB ! "message from main refB"
//    refA ! "message from main refA"
  }

}


case class ActorA(refb:ActorRef) extends  Actor{

  override def receive: Receive = {
    case x => {
      Thread sleep 1000
      println(s"ActorA收到消息：$x")
      val ref = sender()
      println(self == ref)
      ref ! "ActorA Message from ref"
      self ! "ActorA Message from self"
      //refb ! "ActorA Message from refb"
    }
  }
}
class ActorB extends  Actor {
  override def receive: Receive = {
    case x => {
      println(s"ActorB收到消息：$x")
      Thread.sleep(1000)
      sender() ! "ActorB Message"
    }
  }
}
