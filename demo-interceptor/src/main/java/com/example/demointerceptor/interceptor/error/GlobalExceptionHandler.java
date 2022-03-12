package com.example.demointerceptor.interceptor.error;

import com.example.demointerceptor.interceptor.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author 兰建青
 * @title: GlobalExceptionHandler
 * @projectName spring-boot-test
 * @description: 全局异常处理类
 * @date 2022/3/12 11:49
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param e	ResponseResultException
     * @return	ErrorResult
     */
    @ExceptionHandler(ResponseResultException.class)
    public ErrorResult responseResultException(ResponseResultException e) {
        log.error("自定义异常！原因是: 【{}】", e.getMessage());
        return ErrorResult.globalFail(e);
    }

    /**
     * 拦截抛出的异常，@ResponseStatus：用来改变响应状态码
     * @param e Throwable
     * @return ErrorResult
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult throwable(Throwable e) {
        e.printStackTrace();
        log.error("发生未知异常！原因是: 【{}】", e.getMessage());
        ErrorResult errorResult = ErrorResult.fail(e.getMessage());
        return errorResult;
    }

    /**
     * 404异常
     * @param e NoHandlerFoundException
     * @return ErrorResult
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ErrorResult noHandlerFoundException(NoHandlerFoundException e) {
        log.error("404异常！原因是: 【{}】", e.getMessage());
        ErrorResult errorResult = ErrorResult.fail(ResultEnum.NOT_FOUND);
        return errorResult;
    }

    /**
     * 参数校验异常
     * @param e BindException
     * @return ErrorResult
     */
    @ExceptionHandler(BindException.class)
    public ErrorResult bindException(BindException e) {
        log.error("发生参数校验异常！原因是：【{}】", e.getMessage());
        return ErrorResult.fail(e.getMessage());
    }

    /**
     * 方法参数无效异常
     * @param e MethodArgumentNotValidException
     * @return ErrorResult
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("发生参数校验异常！原因是：【{}】", e.getMessage());
        return ErrorResult.fail(e.getMessage());
    }
}
