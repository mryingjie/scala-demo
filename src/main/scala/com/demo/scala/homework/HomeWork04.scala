package com.demo.scala.homework

import java.util

/**
  * create by ZhengYingjie on 2019/1/16 14:32
  */
object HomeWork04 extends App {

  import util.{HashMap => JavaHashMap}

  import collection.mutable.{HashMap => ScalaMap}
  val javaMap = new JavaHashMap[Int,String]()

  javaMap.put(1,"one")
  javaMap.put(2,"two")
  javaMap.put(3,"three")
  val set: util.Set[Int] = javaMap.keySet()

  val map = new ScalaMap[Int,String]
  for(key <- set.toArray()){
    map+=(key.asInstanceOf[Int]->javaMap.get(key))
  }

  println(map.mkString("|").replaceAll(" -> ","="))
}
