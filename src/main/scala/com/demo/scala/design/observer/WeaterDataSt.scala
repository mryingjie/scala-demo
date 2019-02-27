package com.demo.scala.design.observer
import java.util
import java.util.Observer
import java.util.function.Consumer



/**
  * create by ZhengYingjie on 2019/2/25 19:16
  */
class WeaterDataSt extends Observable{

  val obs:util.List[Observer]  = new util.ArrayList[Observer]()

  override def addObserver(o: Observer): Unit = {
    obs.add(o)
  }

  override def removeObserver(o: Observer): Unit = {
    val iterator = obs.iterator
    if(iterator.hasNext){
      val observer = iterator.next()
      if(observer == o){
        iterator.remove()
      }
    }
  }

  override def notifyAll(arg: Object): Unit = {
    val thisInstance = this
    obs.forEach(new Consumer[Observer] {
      override def accept(t: Observer): Unit = {
        t.update(thisInstance,arg)
      }
    })
  }

  override def changeData(arg: Object): Unit = {
    notifyAll(arg)
  }
}
