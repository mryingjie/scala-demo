package com.demo.scala.exception;

import com.demo.scala.construct.Person;
import org.junit.Test;

/**
 * @author ZhengYingjie
 * @time 2019/1/11 17:52
 * @description
 */
public class TestException {

    public static void main(String[] args) {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        exceptionDemo.myexception();
        exceptionDemo.myExcpetion2();


    }

    @Test
    public void test(){
        Person person = new Person();
        person.setName("ss");
        System.out.println(person.getName());
        testLong(0!=1?0:1L);
    }

    void testLong(Long nu){
        System.out.println(nu);
    }
}
