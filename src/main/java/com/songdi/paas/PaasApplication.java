package com.songdi.paas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.songdi.paas.admin.mapper")
public class PaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaasApplication.class, args);
    }

}
