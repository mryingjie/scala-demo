package com.demo.scala.design.observer

/**
  * create by ZhengYingjie on 2019/2/25 19:23
  */
object Client {

  def main(args: Array[String]): Unit = {

    //创建一个观察者
    val conditions = new CurrentConditions

    //创建被观察者气象局官方公告板  可以扩展 实现Observable特质即可
    val st = new WeaterDataSt
    st.addObserver(conditions)

    st.addObserver(new SnnaCurrentConditions)


    st.changeData(Messagge(12,34,1))

  }

}
