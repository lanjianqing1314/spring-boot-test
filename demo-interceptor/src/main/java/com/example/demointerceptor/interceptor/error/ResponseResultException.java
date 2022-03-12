package com.example.demointerceptor.interceptor.error;

import com.example.demointerceptor.interceptor.ResultEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author 兰建青
 * @title: ResponseResultException
 * @projectName spring-boot-test
 * @description: 应用返回异常
 * @date 2021/1/12 11:13
 */
@NoArgsConstructor
@Getter
public class ResponseResultException extends RuntimeException {

    private ResultEnum resultEnum;

    public ResponseResultException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum;
    }

    public ResponseResultException(String msg) {
        super(msg);
    }
}
