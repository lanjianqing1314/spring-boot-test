package com.example.demointerceptor.interceptor;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 兰建青
 * @title: BaseResult
 * @projectName spring-boot-test
 * @description: 返回类型跟类
 * @date 2021/1/12 11:44
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class BaseResult<T> implements Serializable {
    protected Integer code;
    protected String msg;
    protected T data;
}
