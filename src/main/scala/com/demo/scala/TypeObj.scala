package com.demo.scala

/**
  * create by ZhengYingjie on 2019/1/3 10:23
  */
object TypeObj {

  def main(args: Array[String]): Unit = {

    val no = say()
    println(s"no = $no")


    val dog: Dog = null

    //    val char: Char = null
    println("over~~~")
  }


  def say(): Unit = {
    println("say!!")
  }
}

class Dog {

}
