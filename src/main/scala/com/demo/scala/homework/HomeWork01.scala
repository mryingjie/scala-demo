package com.demo.scala.homework

/**
  * create by ZhengYingjie on 2019/1/3 10:39
  */
object HomeWork01 {

  def main(args: Array[String]): Unit = {
    //  1、在Scala REPL(read->evaluateion->print->loop)中，计算3的平方根,然后再对该值求平方。现在，这个结果与3相差多少？
    //  提示：scala.math 找相应的方法

    val no1 = 3
    //平方根
    val no2 = math.sqrt(3)
    //平方
    val no3 = math.pow(no2, 2)
    println(no3 - 3)

    //  8、Scala允许你用数字去乘一个字符串，去REPL中试一下"crazy"*3。这个操作做什么？在Scaladoc中如何找到这个操作?
    val result = "crazy" * 3
    println(result)

    //  9、10 max 2的含义是什么？max方法定义在哪个类中？
    println(10 max 2)

    //  10、用BigInt计算2的1024次方
    //  提示：在BigInt 找相应的方法
    //    val nu1 = new BigInt(BigInteger.valueOf(2))
    //    val nu1 = BigInt.apply(2)
    val nu1 = BigInt(2)
    println(s"nu1 = $nu1")
    val result2 = nu1.pow(1024)
    println(s"2的1024次方 = $result2")

    //  11、在Scala中如何获取字符串“Hello”的首符和尾字符？
    //  提示: 在String中找相应的方法

    val str: String = new String("Hello")
    //    val first  = str.charAt(0)
    //    val first  = str(0)
    val first = str.take(1)

    //    val last = str.charAt(str.length-1)
    //    val last = str(str.length-1)
    val last = str.takeRight(1)
    println(s"first = $first")
    println(s"last = $last")

    val a = 2
    val b = 3

    val res = if (a < b) "a>b" else true
    println(s"res = $res")

  }


}
