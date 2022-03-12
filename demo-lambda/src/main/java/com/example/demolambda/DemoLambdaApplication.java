package com.example.demolambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoLambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoLambdaApplication.class, args);
        new Thread(()->System.out.println(123)).start();
    }

}
