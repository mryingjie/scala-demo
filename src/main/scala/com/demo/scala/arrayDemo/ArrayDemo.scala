package com.demo.scala.arrayDemo


import org.junit.Test

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
  * create by ZhengYingjie on 2019/1/28 18:38
  */

class ArrayDemo {


  @Test
  def testArrayToJavaLit(): Unit = {
    val buffer = ArrayBuffer("s", "21", "12")

    import scala.collection.JavaConversions.bufferAsJavaList

    //    val ints = buffer.asInstanceOf[util.List[String]]
    //    println(ints)
    //这里触发隐式转换
    val strings = new ProcessBuilder(buffer).command()
    println(strings)

    //再将JAVA的List转换为为SCALA的Buffer

    import scala.collection.JavaConversions.asScalaBuffer
    val buffer2: mutable.Buffer[String] = strings
    print(buffer2)
  }

  @Test
  def testArray(): Unit = {
    val ints = new Array[Int](10)
    val ints2 = Array[Int](1, 2, 19, 2)
    val array = Array(2, "s", 2, 31)
    ints2(2) = 3 //可修改

    println(ints.mkString(","))
    println(ints2.mkString)
    println(array.mkString("!", ",", "*"))
    val buffer = ints.toBuffer

  }

  @Test
  def testArrayBuffer(): Unit = {
    val ints = new ArrayBuffer[Int](10)
    val ints2 = ints :+ 2
    println(s"ints = $ints")
    println(s"ints2 = $ints2")
    ints.append(2,4,3)
    ints += 2 += 199

    ints ++= ints2
    println(s"ints = $ints")
    val array = ints.toArray
  }

  //创建多维数组
  @Test
  def testDim(): Unit = {
    val array: Array[Array[Int]] = Array.ofDim[Int](3, 4)

    for (item <- array) {
      for (i <- item) {
        print(i + "\t")
      }
      println()
    }


    println("array(2)(3) = " + array(2)(3))

    array(2)(3) = 19

    println("array(2)(3) = " + array(2)(3))

  }

}
