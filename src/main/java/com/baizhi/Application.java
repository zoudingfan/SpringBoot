package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //开启springboot应用
@MapperScan("com.baizhi.dao") //指定哪个包创建dao实现类
public class Application {
    public static void main(String[] args) {
       //启动springboot应用
        SpringApplication.run(Application.class,args);
    }
}
