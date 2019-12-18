package com.itheima.canal;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 * @EnableCanalClient声明当前的服务是canal的客户端
 * @author JinLu
 */
@SpringBootApplication
@EnableCanalClient
public class CanalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }

}
