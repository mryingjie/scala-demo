package com.demo.scala

import org.junit.Test

import util.control.Breaks._


/**
  * create by ZhengYingjie on 2019/1/3 16:22
  */
object CycleDemo {

  def main(args: Array[String]): Unit = {
    var res:IndexedSeq[Int] = null
    breakable {
      res = for (i <- 1 to 10 if i % 2 == 0; j = i + 10) yield {
        print(s"i = $i, ")
        print(s"j = $j, ")
//        if (i > 7) {
//          break()
//        }
        i + j
      }
      println()
    }
    println("res = " + res)
//
//
//    val list = List("a", "b", 12, 23.2)
//
//    for (item <- list if item.isInstanceOf[String]) {
//      print(item + " ")
//    }

//    println()
//    for (i <- 0 until 10 if i % 2 == 0) {
//      print(s"i = $i, ")
//    }

//    println()
//    for (i <- Range(1, 10, 2)) {
//      println("range i = " + i)
//    }
  }
}
