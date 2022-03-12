package com.example.demointerceptor.interceptor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author 兰建青
 * @title: ResultEnum
 * @projectName spring-boot-test
 * @description: 返回枚举
 * @date 2021/1/12 9:53
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "系统错误"),
    NOT_FOUND(404, "api不存在");

    private Integer code;
    private String msg;
}
