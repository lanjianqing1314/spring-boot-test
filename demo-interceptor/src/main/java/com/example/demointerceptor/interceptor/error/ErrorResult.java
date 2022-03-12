package com.example.demointerceptor.interceptor.error;

import com.example.demointerceptor.interceptor.BaseResult;
import com.example.demointerceptor.interceptor.ResultEnum;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author 兰建青
 * @title: ErrorResult
 * @projectName spring-boot-test
 * @description: 系统异常返回结果
 * @date 2021/1/12 11:43
 */
@NoArgsConstructor
@EqualsAndHashCode
public class ErrorResult extends BaseResult {

    public ErrorResult(String data) {
        this.code = ResultEnum.ERROR.getCode();
        this.msg = ResultEnum.ERROR.getMsg();
        this.data = data;
    }

    public ErrorResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public static ErrorResult globalFail(ResponseResultException e) {
        if (Objects.isNull(e.getResultEnum())) {
            return new ErrorResult(e.getMessage());
        }
        return new ErrorResult(e.getResultEnum());
    }

    public static ErrorResult fail(String data) {
        return new ErrorResult(data);
    }

    public static ErrorResult fail(ResultEnum resultEnum) {
        return new ErrorResult(resultEnum);
    }
}
