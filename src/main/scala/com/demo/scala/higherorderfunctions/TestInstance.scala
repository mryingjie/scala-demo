package com.demo.scala.higherorderfunctions

import org.junit._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


/**
  * create by ZhengYingjie on 2019/2/11 14:55
  */
class TestInstance {


  @Test
  def testFold(): Unit ={

    val sentence = ("A" * 8) + ("B" * 6) + ("C" * 5) + ("D" * 7)

    //折叠
    val chars = sentence.foldLeft(new ArrayBuffer[Char]())((arr:ArrayBuffer[Char] , a:Char) => {arr.append(a); arr})

    println(sentence)

    println(chars)
  }


  @Test
  def testMap(): Unit ={
    val sentence = ("A" * 8) + ("B" * 6) + ("C" * 5) + ("D" * 7)

    def checkCount(map:mutable.Map[Char,Int] , c: Char): mutable.Map[Char,Int] ={
      val value = map.getOrElse(c,0) + 1
      map += (c -> value)
//      map + (c -> value) 新创建一个map
    }

    val charToInt = mutable.Map[Char,Int]()

    val resut = sentence.foldLeft(charToInt)(checkCount)

    println(charToInt == resut)
    println(resut)
  }

  @Test
  def testWordCount(): Unit ={
    val list = List("super hero java scala hadoop hadoop" , "hadoop java" , "java scala")

    //将每行的单词切分出来
    def wordCount(map:mutable.Map[String,Int],str : String): mutable.Map[String,Int] ={
      map  += (str -> (map.getOrElse(str,0) + 1))
    }

    val stringToInt = mutable.Map[String,Int]()
    list.par.map(a => a.split(" ").foldLeft(stringToInt)(wordCount))

    val seq1 = stringToInt.par.toList.sortBy(_._2) //按自身排序
    val seq2 = stringToInt.par.toList.sortWith(_._2 < _._2) //按自定义函数排序

    implicit val valueOrdering = new Ordering[(String, Int)] {
      override def compare(x: (String, Int), y: (String, Int)): Int = {
        x._2.compareTo(y._2)
      }
    }
    val seq3 = stringToInt.par.toList.sorted// valueOrdering 使用隐式排序函数
    println(stringToInt)
    println(seq1)
    println(seq2)
    println(seq3)
  }


  @Test
  def test(): Unit ={
    val str = "ds ,dsa fd"
    println(str.split(" ").mkString("$"))
  }

}
