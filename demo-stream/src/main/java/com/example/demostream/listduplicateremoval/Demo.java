package com.example.demostream.listduplicateremoval;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * @author 兰建青
 * @title: Demo
 * @projectName spring-boot-test
 * @description: list集合去重
 * @date 2022/3/1223:07
 */
@Slf4j
public class Demo {
    public static void main(String[] args) {
        List<UserDTO> dtoList = new ArrayList<>(16);
        dtoList.add(new UserDTO().setId(1L).setName("test").setAge(10));
        dtoList.add(new UserDTO().setId(2L).setName("test").setAge(10));
        dtoList.add(new UserDTO().setId(3L).setName("test").setAge(10));
        dtoList.add(new UserDTO().setId(2L).setName("test").setAge(10));

        log.info("去重之前：【{}】", dtoList);
        dtoList = dtoList.stream()
                .collect(
                        collectingAndThen(
                                toCollection(
                                        () -> new TreeSet<>(Comparator.comparing(UserDTO::getId))
                                ),
                                ArrayList::new
                        )
                );
        log.info("去重之后：【{}】", dtoList);
    }
}
