package com.demo.scala.project

import com.demo.scala.project.bean.Customer
import com.demo.scala.project.service.CustomerService
import com.demo.scala.project.service.impl.CustomerServiceImpl
import org.springframework.util.StringUtils

import scala.io.StdIn
import util.control.Breaks._
/**
  * create by ZhengYingjie on 2019/2/18 10:37
  */
object CustomerView {

  def main(args: Array[String]): Unit = {
    val view = new CustomerView

    while (true){
      val line = view.showIndex()
      if(line.equals("1")){
        //      1 添 加 客 户
        view.addCustomer();
        println("添加成功！！")
      }else if(line.equals("2")){
        //      2 修 改 客 户
        println("修改客户")
        val size = view.showCustomerList()
        println(s"请选择0-${size-1}")
        val index = StdIn.readLine().toInt
        view.modifyCustomer(index)
        view.showCustomerList()
      }else if(line.equals("3")){
        //      3 删 除 客 户
        println("删除客户")

      }else if(line.equals("4")){
        //      4 客 户 列 表
        println("客户列表")
        view.showCustomerList()

      }else if(line.equals("5")){
        //      5 退       出
        System.exit(0)
      }else if(StringUtils.isEmpty(line)){

      }else{
        println("没有此选项！请重新输入")
      }
    }

  }

}

class CustomerView{
  val service:CustomerService = new CustomerServiceImpl

  /**
    * 查询客户列表
    */
  def showCustomerList(): Int = {
    val list = service.customerList
    println("请选择(1-5)：4\n\n" +
      "---------------------------客户列表---------------------------\n" +
      "编号\t\t\t\t姓名\t\t\t\t年龄\t\t\t\t电话\t\t\t\t资产(元) ")
    for (i <- 0 until list.size){
      val customer = list(i)
      println(s"$i\t\t\t\t${customer.name}\t\t\t\t${customer.age}\t\t\t\t${customer.phone}\t\t\t\t${customer.amount}")
    }

    println("-------------------------客户列表完成-------------------------")
    list.size
  }

  def modifyCustomer(index:Int): Unit ={
//    service.modifyCustomer();
    service.modifyCustomer(index)
    println("修改完成！！！！")
  }

  /**
    * 添加客户
    */
  def addCustomer(): Unit = {
    println("请输入：")
    print("姓名：")
    val name = StdIn.readLine
    print("年龄：")
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
    print("电话：")
    val phone = StdIn.readLine
    print("资产：")
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
    service.addCustomer(Customer(name,age,phone,amount))
  }

  //显示主页面
  def showIndex(): String ={
    println("-----------------客户信息管理软件-----------------\n\n" +
      "                  1 添 加 客 户\n" +
      "                  2 修 改 客 户\n" +
      "                  3 删 除 客 户\n" +
      "                  4 客 户 列 表\n" +
      "                  5 退       出\n\n" +
      "                  请选择(1-5)：_")
    var line = StdIn.readLine
    line
  }



}