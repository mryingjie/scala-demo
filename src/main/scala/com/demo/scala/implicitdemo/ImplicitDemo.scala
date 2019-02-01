package com.demo.scala.implicitdemo

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/22 16:09
  */
class ImplicitDemo {

  implicit val str: String = "jack"

  //隐式类
  implicit class DB(mySql: MySql){
    def delete(): Unit ={
      println("delete")
    }
  }

  @Test
  def test(): Unit ={

    val num:Int = 3.8
    println(num)



    val mysql:MySql = new MySql
    mysql.insert()
    mysql.update() // 隐式转换
    mysql.delete()  // 隐式类转换
    f3 //隐式参数
  }


  implicit def f2(mysql:MySql): Orcal={
    new Orcal
  }

  def f3(implicit str:String): Unit ={
    println(str)
  }

  implicit def f1(d:Double): Int ={
    d.toInt
  }

}

class MySql(){

  def insert(): Unit ={
    println("insert")
  }


}


class Orcal(){
  def update(): Unit ={
    println("update")
  }
}
