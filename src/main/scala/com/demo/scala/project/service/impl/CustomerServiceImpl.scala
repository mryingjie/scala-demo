package com.demo.scala.project.service.impl

import com.demo.scala.project.bean.Customer
import com.demo.scala.project.service.CustomerService

import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}


/**
  * create by ZhengYingjie on 2019/2/20 15:36
  */
class CustomerServiceImpl extends CustomerService{

  override def addCustomer(customer: Customer): Customer = {
    customerList.append(customer)
    customer
  }
  override def deleteCustomer(index: Int): Unit = ???

  override def modifyCustomer(index: Int): Customer = {
    val customer = customerList(index)
    println("请输入：")
    print(s"姓名(${customer.name})：")
    val name = StdIn.readLine
    customer.name=name
    print(s"年龄(${customer.age})：")
    var age:Int=0
    breakable{
      while (true){
        try {
          age= StdIn.readLine().toInt
          break()
        }catch {
          case ex:Exception=> {
            println("参数不合法，请重新输入")
          }
        }
      }
    }
    customer.age=age
    print(s"电话(${customer.phone})：")
    val phone = StdIn.readLine
    customer.phone=phone
    print(s"资产(${customer.amount})：")
    var amount:Double = 0.0;
    breakable{
      while (true){
        try {
          amount = StdIn.readLine().toDouble
          break()
        }catch {
          case ex:Exception=> {
            println("参数不合法，请重新输入")
          }
        }
      }
    }
    customer.amount=amount
    customer
  }

  override def listCustomers(): Unit = ???
}
