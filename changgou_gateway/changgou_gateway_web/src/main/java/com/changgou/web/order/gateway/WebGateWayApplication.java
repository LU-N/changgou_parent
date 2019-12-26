package com.changgou.web.order.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author JinLu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WebGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebGateWayApplication.class, args);
    }
}
