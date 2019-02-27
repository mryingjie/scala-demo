package com.demo.scala.generic

import com.demo.scala.generic.SeasonEnum.SeasonEnum

/**
  * create by ZhengYingjie on 2019/2/26 20:04
  *
  * 要求
  * 请设计一个EnglishClass (英语班级类)，在创建EnglishClass的一个实例时，需要指定[ 班级开班季节(spring,autumn,summer,winter)
  * 、班级名称、班级类型]
  * 开班季节只能是指定的，班级名称为String, 班级类型是(字符串类型 "高级班", "初级班"..) 或者是 Int 类型(1, 2, 3 等)
  * 请使用泛型来完成本案例.
  *
  */
class EnglishClass[A,B,C](val classSesaon:A,val className:B,val classType:C)


object SeasonEnum extends Enumeration{



  type SeasonEnum = Value

  val Spring =  Value(100, "春季")

}

object TestClient{

  def main(args: Array[String]): Unit = {
    new EnglishClass[SeasonEnum,String,Int](SeasonEnum.Spring,"0705班",100)
  }


}