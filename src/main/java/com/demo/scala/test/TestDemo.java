package com.demo.scala.test;

/**
 * @author ZhengYingjie
 * @time 2019/2/25 10:23
 * @description
 */

public strictfp class TestDemo {

    public strictfp  static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        System.out.println(testDemo.getResult());

    }

    private strictfp double getResult(){
        double a = 1.232 * 2;//2.464

        double b = 1.1112;

        //3.5752
        return a +b;
    }
}
