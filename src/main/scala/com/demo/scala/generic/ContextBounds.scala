package com.demo.scala.generic

/**
  * create by ZhengYingjie on 2019/2/27 14:12
  * 上下文界定应用实例
  * 要求：使用上下文界定+隐式参数的方式，比较两个Person对象的年龄大小
  * 要求：使用Ordering实现比较
  */
object ContextBounds {

  //隐式值 给下面的三种反式自动传参
  implicit val personCOmoaretor = new Ordering[Person] {
    override def compare(x: Person, y: Person): Int = {
      x.age - y.age
    }
  }

  def main(args: Array[String]): Unit = {
    val jack = new Person(12,"jack")
    val tom = new Person(15,"Tom")
    val geatter1 = new CompareComm[Person](jack,tom).geatter
    val geatter2 = new CompareComm2[Person](jack,tom).geatter

    val geatter3= new CompareComm3[Person](jack,tom).geatter

    println(geatter1.name)

    println(geatter2.name)

    println(geatter3.name)
  }

}


class Person1(val age:Int,val name :String){
}


//方式一 隐式值传参
class CompareComm[T:Ordering](obj1:T,obj2:T)(implicit comparator:Ordering[T]){

  def geatter = if (comparator.compare(obj1,obj2)>0) obj1 else obj2

}

//反式二
class CompareComm2[T:Ordering](obj1:T,obj2:T){

  def geatter = {
    def f1(implicit comptor:Ordering[T]) = comptor.compare(obj1,obj2)

    if(f1 >0) obj1 else obj2
  }

}

//方式三 使用implucitly语法糖
class CompareComm3[T:Ordering](obj1:T,obj2:T){

  def geatter = {

    val comptor = implicitly[Ordering[T]]

    if(comptor.compare(obj1,obj2)>0) obj1 else obj2

  }

}