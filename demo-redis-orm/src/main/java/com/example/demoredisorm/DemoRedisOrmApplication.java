package com.example.demoredisorm;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author W9012269
 */
@SpringBootApplication
@EnableRedisDocumentRepositories(basePackages = "com.example.demoredisorm.*")
public class DemoRedisOrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRedisOrmApplication.class, args);
    }

}
