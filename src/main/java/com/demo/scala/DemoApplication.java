package com.demo.scala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhengYingjie
 * @time 2019/1/3 15:11
 * @description
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        HomeWork01.main(args);
        SpringApplication.run(DemoApplication.class, args);
    }
}
