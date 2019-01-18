package com.demo.scala.homework.work05

import org.junit.Test


/**
  * create by ZhengYingjie on 2019/1/18 15:37
  */
class ClientClass {

  //  1、编写一个Conversions对象，加入 inchesToCentimeters,gallonsToLiters
  // 和 milesToKilometers 方法
  //
  //  2、定义一个 Point 类和一个伴生对象,使得我们可以不用 new 而直接用
  // Point(3,4)来构造 Point 实例 apply 方法的使用
  //
  //  3、编写一个 Scala 应用程序,使用 App 特质,以反序打印命令行参数,用空格隔开。
  // 举例来说,scala Reverse Hello World 应该打印 World Hello
  //

  //  4、编写一个扑克牌 4 种花色的枚举,让其 toString 方法分别返回♣,♦,♥,♠，
  // 并实现一个函数,检查某张牌的花色是否为红色


  @Test
  def testSuits(): Unit ={
    println(Suits)

    println(Suits.isRed(Suits.CLUB))
    println(Suits.isRed(Suits.SPADE))
    println(Suits.isRed(Suits.HEART))
    println(Suits.isRed(Suits.DIAMOND))
  }

  object Suits extends Enumeration{
//    type Suits = Value
     val SPADE = Value("♣")
     val CLUB = Value("♦")
     val HEART = Value("♥")
     val DIAMOND = Value("♠")

    override def toString(): String = Suits.values.mkString(",")

    def isRed(suit:Value): Boolean ={
      suit == CLUB || suit == HEART
    }
  }



  //  1、扩展如下的BankAccount类，新类CheckingAccount对每次存款和取款都收取1美元的手续费
  @Test
  def test01(): Unit = {
    val account02 = new BankAccount02(1000)
    val account = new BankAccount(1000)

    println("当前余额="+account02.checkAccount())
    println("存1000")
    account02.deposit(1000)
    println("当前余额="+account02.checkAccount())
    println("取100")
    account02.withdraw(100)
    println("当前余额="+account02.checkAccount())

  }
  class BankAccount(initialBalance: Double) {
    private var balance = initialBalance

    private val interestRate = 0.1

    private val freeTime = 3

    //存款
    def deposit(amount: Double) = {
      balance += amount; balance
    }

    //取款
    def withdraw(amount: Double) = {
      balance -= amount; balance
    }

    def checkAccount() = this.balance

    def earnMonthlyInterest(): Unit ={

    }

  }

  class BankAccount02(initialBalance: Double) extends BankAccount(initialBalance) {

    private val rate = 0.1

    override def deposit(amount: Double): Double = {
      super.deposit(amount - amount * rate)
    }

    override def withdraw(amount: Double): Double = {
      super.withdraw(amount * rate)
      super.withdraw(amount)
    }
  }

}
