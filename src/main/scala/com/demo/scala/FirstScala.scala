package com.demo.scala

import com.demo.scala.construct.Person
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource

import scala.collection.mutable


/**
  *
  */
object FirstScala {


  def main(args: Array[String]): Unit = {

    println("hello scala")
    val num1: Int = 1
    val num2: Int = 2
    println(num1 + num2)

    val name: String = "张三"
    val age = 18
    val sal = 299.288f
    val height = 190.2
    //格式化输出1
    printf("姓名：%s 年龄：%d 薪水：%.3f 身高：%.2f\n", name, age, sal, height)
    //格式化输出2
    println(s" 姓名：$name \n 年龄：${18 + 10} \n 薪水：$sal \n 身高：$height ")

//    say()
    DemoApplication.main(args)
  }

  def sum(num: Int, num2: Int): Int = {
    num + num2
  }

  def say(): Nothing={
      throw new RuntimeException("运行时异常")
  }


}
