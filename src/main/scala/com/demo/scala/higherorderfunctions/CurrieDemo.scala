package com.demo.scala.higherorderfunctions

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/14 11:37
  */
class CurrieDemo {

  //编写一个任何字符串都能调用的函数  按不同的规则与另一个函数进行比较


  implicit class CheckStrings(s:String){

    def checkString(str:String)(f:(String, String) => Boolean): Boolean ={
      f(s,str)
    }

  }

  @Test
  def test(): Unit ={
    val s = "Hello"
    println(s.checkString("hello")(_.equalsIgnoreCase(_))) //忽略大小写比较

    println(s.checkString("asdd")(_.length == _.length)) //比较长度
  }


}
