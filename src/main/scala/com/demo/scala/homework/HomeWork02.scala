package com.demo.scala.homework

import scala.util.control.Breaks._
/**
  * create by ZhengYingjie on 2019/1/4 10:37
  */
object HomeWork02 {

  def main(args: Array[String]): Unit = {
    //100以内的数求和，求出当和第一次大于20的当前数

    var j = 0
    breakable{
      var sum = 0
      for (i <- 0 to 100) {
        sum+=i
        if(sum>20){
          j = i
          println(s"sum = $sum")
          break()
        }
      }
    }
    println("j = " + j)
  }

}
