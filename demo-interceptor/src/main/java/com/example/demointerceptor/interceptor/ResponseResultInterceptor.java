package com.example.demointerceptor.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 兰建青
 * @title: ResponseResultEnum
 * @projectName spring-boot-test
 * @description: 注解拦截
 * @date 2021/1/12 9:27
 */
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            // 判断是否在类对象上添加的注解
            if (clazz.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(String.valueOf(ResponseResultEnum.RESPONSE_RESULT_ANN), clazz.getDeclaredAnnotation(ResponseResult.class));
            } else if (method.isAnnotationPresent(ResponseResult.class)) {
                request.setAttribute(String.valueOf(ResponseResultEnum.RESPONSE_RESULT_ANN), method.getDeclaredAnnotation(ResponseResult.class));
            }
        }
        return true;
    }
}
