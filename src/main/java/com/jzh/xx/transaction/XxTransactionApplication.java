package com.jzh.xx.transaction;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages = "com.jzh.xx.transaction.mapper")
@EnableTransactionManagement
public class XxTransactionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(XxTransactionApplication.class, args);
    }

}
