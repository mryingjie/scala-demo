package com.demo.scala.matchDemo

import org.junit._

/**
  * create by ZhengYingjie on 2019/2/13 10:50
  */
class MatchInstanceSale {
  val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)),Bundle("优惠二套餐",
    30,Book("三体",90),Book("球形闪电",100)))


  @Test
  def testFinal(): Unit ={
    //设计一个方法计算商品打折后的价格
    /**
      * 商品捆绑可以是单个商品，也可以是多个商品。
      * 打折时按照折扣xx元进行设计.
      * 能够统计出所有捆绑商品打折后的最终价格
      */
    def getPrice(item: Iteme): Double ={
      item match {
        case Book(_,price) => price
        case Bundle(_,discount,other @ _*) =>{
          other.map(getPrice _).sum - discount
        }
      }
    }

    println(getPrice(sale))

  }

  /**
    * val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))
    * 取出这个嵌套结构中的 "漫画"
    */
  @Test
  def test01(): Unit ={

    val desc =sale match {
      case Bundle(_,_,Book(desc,_),_*) => desc
    }
    println(desc)
  }

  /**
    * val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))
    * 这个嵌套结构中的 "漫画" 和 Bundle的部分 绑定到变量，即赋值到变量中.
    */
  @Test
  def test02(): Unit ={
    val result = sale match {
      case Bundle(_,_,Book(desc @ _,_),other @ _*) => (desc,other)
    }
    println(result)
  }

// 在02基础上 不使用_*绑定剩余Item到rest
  @Test
  def test03(): Unit ={
    val sale1 = Bundle("书籍", 10,  Book("漫画", 40))

    val result = sale1 match {
      case Bundle(_,_,x) =>x
      case Bundle(_,_,Book(desc,_),other) => (desc,other)
      case x =>x
    }
    println(result)
  }

}


abstract class Iteme
case class Book(desc:String,price:Double) extends Iteme{
  var author:String = _
  override def toString: String = s"Book(${desc},$price,$author)"
}
case class Bundle(desc:String,discount:Double,item:Iteme*) extends Iteme