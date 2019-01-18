package com.demo.scala.homework

/**
  * create by ZhengYingjie on 2019/1/3 17:11
  */
object ForHomework {

  def main(args: Array[String]): Unit = {

    //输出0-100的所有的9的倍数的个数和总和

    var count = 0
    var sum = 0
    for(i <- 0 to 100 if i % 9 == 0){
      count += 1
      sum += i
    }
    println(s"count = $count , sum = $sum")
  }

}
