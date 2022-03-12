package com.example.demointerceptor.interceptor;

import java.lang.annotation.*;

/**
 * @author 兰建青
 * @title: ResponseResultEnum
 * @projectName spring-boot-test
 * @description: 返回注解
 * @date 2021/1/12 9:29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface ResponseResult {
}
