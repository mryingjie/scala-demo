package com.demo.scala.homework


import java.util

import org.junit._

import scala.util.Random


/**
  * create by ZhengYingjie on 2019/2/15 14:55
  */
class HomeWork07 {

  /**
    * 1、编写一段代码，将n设置为一个n个随机整数的数组，要求随机数介于0和n之间。
    */
  def mkArray(i: Int): Array[Int] = {
    val arr = new Array[Int](i)
    for (n <- 0 until i) {
      var num = new Random().nextInt(i)
      while (num == 0) num = new Random().nextInt(i)
      arr(n) = num
    }
    arr
  }

  @Test
  def test01(): Unit = {
    val arr: Array[Int] = mkArray(5)
    println(arr.mkString(","))
  }


  /**
    * 2. 编写一个循环，将整数数组中相邻的元素置换。
    * 比如Array(1, 2, 3, 4, 5)置换后为Array(2, 1, 4, 3, 5)
    */
  def replace(arr: Array[Int]): Array[Int] = {
    for (i <- 0 until arr.length - 1 if i % 2 == 0) {
      val temp = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = temp
    }
    arr
  }

  @Test
  def test02(): Unit = {
    val ints = Array(2, 3, 4, 5, 6, 7)
    println(replace(ints).mkString(","))
  }

  /**
    *3. 给定一个整数数组，产出一个新的数组，包含原数组中的所有正值，
    * 以原有顺序排列，之后的元素是所有零或负值，以原有顺序排列。
    */
  def work03(arr: Array[Int]): Array[Int] = {
    val res = new Array[Int](arr.length)
    var j = 0
    for (i <- arr if i > 0) {
      res(j) = i
      j += 1
    }
    for (i <- arr if i <= 0) {
      res(j) = i
      j += 1
    }
    res
  }

  @Test
  def test03(): Unit = {
    println(work03(Array(21, 4, -23, 0, 43, -2, 244)).mkString(","))
  }


  /**
    * 4、设置一个映射，其中包含你想要的一些装备，以及它们的价格。
    * 然后根据这个映射构建另一个新映射，采用同一组键，但是价格上打9折。
    */

  @Test
  def test04(): Unit = {
    val map = Map(("1", 200), ("2", 300), ("3", 400))

    println(map.get("dsdsd"))
    val strings = map.map {
      case (k, v) => {
        (k, v * 0.9) //这里可返回任意类型  如果是元组则会返回一个Map 别的类型就是对应类型的集合
      }
    }
    println(strings)

    val xs = Map("a" -> List(11, 111, 22), "b" -> List(22, 222, 2222)).flatMap(_._2)
    println(xs.mkString(","))
    println(strings.flatMap {
      case (k, v) => {
        "s"
        //        List("s", "ds")
      }
    })
  }

  /**
    * 5、编写一个函数 minmax(values:Array[Int]), 返回数组中最小值和最大值的对偶
    */
  def minmax(arr: Array[Int]): (Int, Int) = {
    (arr.max, arr.min)
  }

  @Test
  def test05(): Unit = {
    println(minmax(Array(32, 1, 43, 0, 22, -2)))
  }

  /**
    * 6、编写一个函数，从一个整型链表中去除所有的零值。
    */
  def work06(seq: util.LinkedList[Int]): util.LinkedList[Int] = {
    var i = 0
    val itr = seq.iterator()
    while (itr.hasNext) {
      val i = itr.next()
      if (i == 0) {
        itr.remove()
      }
    }
    seq
  }

  @Test
  def test06(): Unit = {
    val ints = new util.LinkedList[Int]()
    ints.add(1)
    ints.add(0)
    ints.add(2)
    ints.add(3)
    ints.add(4)
    ints.add(0)
    ints.add(5)
    println(ints.size())
    println(work06(ints))
  }

  /**
    * 7、编写一个函数，接受一个字符串的集合，以及一个从字符串到整数值的映射。
    * 返回整形的集合，其值为能和集合中某个字符串相对应的映射的值。
    * 举例来说，给定Array("Tom","Fred","Harry")
    * 和Map("Tom"->3,"Dick"->4,"Harry"->5)，返回Array(3,5)。
    * 提示：用flatMap将get返回的Option值组合在一起。
    */
  @Test
  def work07(): Unit = {
    val strs = List("Tom", "Fred", "Harry")
    val map = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
    println(strs.map(map.getOrElse(_, null)).filter(_ != null))
  }

  /**
    * 8、实现一个函数，作用与mkStirng相同，提示：使用reduceLeft实现试试
    */
  def mkString02(iter: Iterable[Any], sp: String): String = {
    //    val sb = new java.lang.StringBuilder
    //    val f = (sb:java.lang.StringBuilder,str:String) => sb.append(str).append(sp)
    val sb = iter.foldLeft(new java.lang.StringBuilder)((sb: java.lang.StringBuilder, str: Any) => {
      sb.append(str.toString).append(sp)
    })
    sb.toString().substring(0, sb.lastIndexOf(","))
  }

  @Test
  def testwork08(): Unit = {
    println(mkString02(Array(13, 43, 32), ","))
  }


  /**
    * 9、给定整型列表lst，(lst :\ List[Int]())(_ :: _)得到什么?
    * (List[Int]() /: lst)(_ :+ _)又得到什么？
    * 如何修改他们中的一个，以对原列表进行反向排列?
    */
  @Test
  def test09(): Unit = {
    val lst = List(32, 231, 21, 43)
    println((lst :\ List[Int]()) ((a, b) => b :+ a))
    println((List[Int]() /: lst) ((a, b) => b :: a))
    println(3 :: lst)
    println(lst :+ 3)
  }

  /**
    * 10、编写一个函数，将Double数组转换成二维数组。
    * 传入列数作为参数。举例来说，传入Array(1,2,3,4,5,6)和3列，
    * 返回Array(Array(1,2,3), Array(4,5,6))。
    */
  def work10(arr: Array[Int], n: Int): Array[Array[Int]] = {
    val length = arr.length
    val array: Array[Array[Int]] = Array.ofDim(length / n, n)
    for (i <- 0 until (length)) {
      //计算是哪行哪列的
      //      //行数
      val row = i / n + 1
      //      //列数
      val colum = i % n + 1
      val num = arr(i)
      array(row - 1)(colum - 1) = num
    }
    array

  }

  @Test
  def test10(): Unit = {
    val arrays = work10(Array(1, 2, 3, 4, 5, 6), 3)
    for (item <- arrays) {
      for (i <- item) {
        print(i + "\t")
      }
      println()
    }

  }
}
