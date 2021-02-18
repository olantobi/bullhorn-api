package com.castillelabs.bullhorn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BullhornApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BullhornApiApplication.class, args);
    }

}
