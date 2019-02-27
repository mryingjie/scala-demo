package com.demo.scala.generic

/**
  * create by ZhengYingjie on 2019/2/27 17:36
  * 协变+ 逆变-
  */
object covariant {


  def main(args: Array[String]): Unit = {

    val tem:Temp[Super] = new Temp[Sub]("ss") //协变 支持泛型的继承  即Temp[Sub] 是Temp[Super]的子类

    println(tem)

  }

}


class Temp[+A](var title:String){
  outer=>
  override def toString = s"Temp($title) outer =  ${outer.title}"
}

class Super


class Sub extends Super