package com.demo.scala.function

import org.junit.Test

/**
  * create by ZhengYingjie on 2019/1/10 10:45
  */
class Recursion {

  @Test
  def testFbn(): Unit = {
    var n = 7
    println(s"$n 的斐波那数为：" + fbn(n))
  }

  def fbn(n: Int): Int = {
    if (n == 1 || n == 2) {
      1
    } else {
      fbn(n - 1) + fbn(n - 2)
    }
  }

  @Test
  def testFunction(): Unit = {
    val n = 5
    println(s"f($n)=" + function(n))
  }

  //  已知 f(1)=3; f(n) = 2*f(n-1)+1;请使用递归的思想编程，求出 f(n)的值?
  def function(n: Int): Int = {
    if (n == 1) {
      3
    } else {
      2 * function(n - 1) + 1
    }
  }


  @Test
  def testPeach(): Unit = {

    val day = 10
    val n = 1
    println(funcPeach(day,n))

    println(funcPeach2(1))

  }

  // 有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
  // 以后每天猴子都吃其中的一半，然后再多吃一个。
  // 当到第十天时，想再吃时（还没吃），发现只有1个桃子了。
  // 问题：最初共多少个桃子？

  /**
    * @param n   初始个数
    * @param day 天数
    * @return 第一天的桃子个数
    */
  def funcPeach(day: Int, n: Int): Int = {
    var num = n;
    if (day == 1) {
      num
    } else {
      funcPeach(day - 1, (num + 1) * 2)
    }
  }

  /**
    *
    * @param day 第几天
    * @return 这天的桃子数
    */
  def funcPeach2(day:Int): Int ={
    if(day == 10){
      1
    }else{
      (funcPeach2(day+1)+1)*2
    }
  }


  @Test
  def testBianrySearch(): Unit ={
    val ints = Array(1,2,3,4,5,8,12,34,56,366,1333)

    println(binarySearch(ints,0))
  }




  def binarySearch(arr:Array[Int], num:Int): Int ={
    def binarySearchBin(head: Int, tail: Int, arr: Array[Int], num: Int): Int = {
      var index = (head + tail)/2
      if(arr(index)==num){
        index
      }else{
        if(index<=0||index>=arr.length-1){
          -1
        }else{
          if(arr(index)>num){
            binarySearchBin(head,index-1,arr,num)
          }else{
            binarySearchBin(index+1,tail,arr,num)
          }
        }
      }
    }
    binarySearchBin(0,arr.length-1,arr,num)
  }


}
