package com.demo.scala.exception;

import com.demo.scala.construct.Person;
import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author ZhengYingjie
 * @time 2019/1/11 17:52
 * @description
 */
public class TestException {

    public static void main(String[] args) {
//        ExceptionDemo exceptionDemo = new ExceptionDemo();
//        exceptionDemo.myexception();
//        exceptionDemo.myExcpetion2();

        SortedMap<String,String> sortedMap = new TreeMap<String,String>();
        Object put = sortedMap.put("a", "a");
        String put1 = sortedMap.put("ab", "ab");
        sortedMap.put("bb", "ba");
        sortedMap.put("ba", "ba");
        sortedMap.put("ac", "ac");

        for (String s : sortedMap.keySet()) {
            System.out.println(s);
        }
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
