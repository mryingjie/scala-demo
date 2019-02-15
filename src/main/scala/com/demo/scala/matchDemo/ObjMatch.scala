package com.demo.scala.matchDemo

/**
  * create by ZhengYingjie on 2019/2/12 16:15
  */
object ObjMatch {

  def main(args: Array[String]): Unit = {

    val n = Square(6)

    println(s"n = $n")

    val result = n match{
      case Square(z) => z
    }

    println(s"result = $result")

  }
  
}

object Square{
  def apply(n: Double): Double = n * n

  def unapply(n :Double): Option[Double] = Some(math.sqrt(n))
}