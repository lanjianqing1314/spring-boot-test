package com.example.demointerceptor.interceptor;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 兰建青
 * @title: Result
 * @projectName spring-boot-test
 * @description: 统一返回信息
 * @date 2021/1/12 9:44
 */
@EqualsAndHashCode
@NoArgsConstructor
public class Result<T> extends BaseResult {

    Result(ResultEnum success, T data) {
        this.code = success.getCode();
        this.msg = success.getMsg();
        this.data = data;
    }

    public static <T> Result<T> success(Object data) {
        return new Result(ResultEnum.SUCCESS, data);
    }
}
