package com.example.demostream.listduplicateremoval;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 兰建青
 * @title: User
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2022/3/1223:04
 */
@Data
@ToString
@Accessors(chain = true)
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}
