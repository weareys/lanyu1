package com.ys.lanyu1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ys.lanyu1.mapper")
@EnableTransactionManagement
public class Lanyu1Application {

    public static void main(String[] args) {
        SpringApplication.run(Lanyu1Application.class, args);
    }

}
