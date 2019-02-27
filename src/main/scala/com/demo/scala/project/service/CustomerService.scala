package com.demo.scala.project.service

import com.demo.scala.project.bean.Customer

import scala.collection.mutable.ListBuffer

/**
  * create by ZhengYingjie on 2019/2/20 14:45
  */
trait CustomerService {

  val customerList:ListBuffer[Customer] = new ListBuffer

  def addCustomer(customer: Customer): Customer

  def deleteCustomer(index:Int)

  def modifyCustomer(index:Int): Customer

  def listCustomers()
}
