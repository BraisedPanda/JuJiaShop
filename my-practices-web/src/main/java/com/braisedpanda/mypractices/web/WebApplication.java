package com.braisedpanda.mypractices.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @program: my-practices
 * @description:
 * @author: chenzhen
 * @create: 2019-12-16 09:42
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.braisedpanda.mypractices.web.mapper")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
