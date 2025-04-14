package org.zewang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 默认扫描范围：当前包及其子包
public class SpringbootWeb01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb01Application.class, args);
    }

}
