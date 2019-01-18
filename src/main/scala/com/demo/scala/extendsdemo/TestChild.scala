package com.demo.scala.extendsdemo

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/18 11:30
  */
class TestChild {


  @Test
  def client(): Unit ={
    val ming = Child("小明")
    val hong = Child("小红")
    val li = Child("小李")
    val niming = Child()
    Child.joinGame(ming)
    Child.joinGame(hong)
    Child.joinGame(li)
    Child.joinGame(niming)
    printf("目前有%d个小孩在玩游戏\n",Child.total)
  }

}

class Child(inName:String){
  val name:String = inName

}


object Child{

  var total :Int = 0

  def joinGame(child:Child): Unit ={
    total+=1
    printf("%s加入了游戏...\n",child.name)
  }

  def apply(inName: String): Child = new Child(inName)
  def apply():Child = new Child("匿名小朋友")

}
