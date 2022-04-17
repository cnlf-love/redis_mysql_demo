package com.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.cn.mapper")
public class RedisMysqlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisMysqlDemoApplication.class, args);
    }

}
