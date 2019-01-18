package com.demo.scala.traitDemo

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/18 17:27
  */

class Client{

  @Test
  def test(): Unit ={
    val sql = new MySql with ConnectionTrait {
      override def query(): Unit = {
        println("查询张三")
      }
    }
    sql.inset("zhangsan")
    sql.query()
  }

}

class MySql {

}

class Orcal{

}


trait ConnectionTrait {

  def inset(data:String): Unit ={
    println("插入"+data)
  }

  def query()

}
