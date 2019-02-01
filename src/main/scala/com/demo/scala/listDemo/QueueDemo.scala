package com.demo.scala.listDemo

import org.junit.Test

import scala.collection.mutable

/**
  * create by ZhengYingjie on 2019/1/31 16:05
  */
class QueueDemo {

  @Test
  def testQueue(): Unit ={
    val queue = mutable.Queue(2,3,5)
    queue += 23 += 24 //增加单个元素到队列尾
    println(queue)

    queue ++= List(12,214) //扁平化集合并将元素添加到队列尾
    println(queue)

    queue.enqueue(888) //增加单个元素到队尾

    val i = queue.dequeue()
    println(i) // 将队列头元素弹出

    //返回队列头的元素  不改变原队列
    println("queue.head =" +queue.head)

    //返回队列尾的元素
    println("queue.last ="+queue.last)

    //返回队列除了第一个元素之外的元素

    println("queue.tail =" +queue.tail)

  }

}
