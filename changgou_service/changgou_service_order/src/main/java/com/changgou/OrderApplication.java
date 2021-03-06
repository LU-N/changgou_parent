package com.changgou;

import com.changgou.entity.IdWorker;
import com.changgou.interceptor.FeignInterceptor;
import com.changgou.order.config.TokenDecode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author JinLu
 * @EnableScheduling 开启定时任务
 */
@SpringBootApplication
@EnableEurekaClient
@EnableScheduling
@EnableFeignClients(basePackages = {"com.changgou.goods.feign", "com.changgou.pay.feign"})
@MapperScan(basePackages = {"com.changgou.order.dao"})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }

    /**
     * 解析用户令牌对象
     *
     * @return
     */
    @Bean
    public TokenDecode tokenDecode() {
        return new TokenDecode();
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

    @Bean
    public FeignInterceptor feignInterceptor() {
        return new FeignInterceptor();
    }
}
