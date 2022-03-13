package com.example.demoeasypoi.controller;

import com.example.demoeasypoi.domain.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author 兰建青
 * @title: UserControllerTest
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2021/12/16 12:48
 */
@SpringBootTest
@Slf4j
public class UserControllerTest {

    @Resource
    private UserController userController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        for (int i = 1000; i < 1000000; i++) {
            UserDTO userDTO = new UserDTO()
                    .setUsername("mytest" + i)
                    .setBirthday(LocalDateTimeToDate(LocalDateTime.now()))
                    .setGender(1)
                    .setIcon("/jj/bb/cc1.jpg")
                    .setNickname("張三" + i)
                    .setPhone("18378802590")
                    .setPassword("123_123");
            log.info("保存的結果：【{}】", userController.add(userDTO));
        }
    }

    private Date LocalDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return Date.from(instant);
    }
}