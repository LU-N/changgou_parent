package com.changgou.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author JinLu
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.consumer.dao"})
public class OrderConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumeApplication.class,args);
    }
}
