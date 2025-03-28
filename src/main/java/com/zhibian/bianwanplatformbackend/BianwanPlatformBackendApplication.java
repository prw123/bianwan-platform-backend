package com.zhibian.bianwanplatformbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhibian.bianwanplatformbackend.mapper")
public class BianwanPlatformBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BianwanPlatformBackendApplication.class, args);
    }

}
