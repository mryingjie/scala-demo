package com.demo.scala.generic

/**
  * create by ZhengYingjie on 2019/2/27 10:24
  * 视图界定 与上界比较 支持隐式转换
  */
object ViewBounds {

  def main(args: Array[String]): Unit = {

    val i = new Compares2(2,3).max()
    println(i)

  }

}
class Compares2[T <% Comparable[T]](obj1: T, obj2: T) {

  def max() = {
    if(obj1.compareTo(obj2)>0) obj1 else obj2
  }

}

/**
  * 自己写隐式转换结合视图界定的方式，比较两个Person对象的年龄大小
  *
  * 如果不写隐式转换 需要Person类继承Ordered类才能运行
  */
object ViewBounds2{

  implicit def PersonToOrderPerson(p:Person) = new Ordered[Person] {
    override def compare(that: Person): Int = {
      p.age - that.age
    }
  }

  def main(args: Array[String]): Unit = {
    val jack = new Person(12,"jack")
    val tom = new Person(15,"Tom")

    val person = new CompareCommon[Person](jack,tom).getter()

    println(person.name)

  }
}


class Person(val age:Int,val name :String){
}

class CompareCommon[T <% Ordered[T]](obj1:T,obj2:T){

   def getter() ={
     if(obj1.compareTo(obj2)>0) obj1 else obj2
   }

}