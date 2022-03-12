package com.example.demointerceptor.interceptor;

import com.example.demointerceptor.interceptor.error.ErrorResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author 兰建青
 * @title: ResponseResultHandler
 * @projectName spring-boot-test
 * @description: 统一格式返回
 * @date 2021/1/12 9:25
 */
@ControllerAdvice
@Slf4j
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    private static final String RESPONSE_RESULT_ANN = String.valueOf(ResponseResultEnum.RESPONSE_RESULT_ANN);

    private static final Map<Class, Function<Object, Object>> STRATEGY_PATTERN_MAP = new HashMap<>(16);

    /**
     * 策略模式
     */
    @PostConstruct
    public void strategyPatternInit(){
        STRATEGY_PATTERN_MAP.put(ErrorResult.class, body -> body);
        STRATEGY_PATTERN_MAP.put(Result.class, body -> body);
        STRATEGY_PATTERN_MAP.put(String.class, this::stringResultMapper);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        ResponseResult responseResult = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
        return !Objects.isNull(responseResult);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Function<Object, Object> result = STRATEGY_PATTERN_MAP.get(Objects.requireNonNull(body).getClass());
        if (Objects.isNull(result)) {
            return Result.success(body);
        }
        return result.apply(body);
    }

    private Object stringResultMapper(Object body) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(Result.success(body));
        } catch (JsonProcessingException e) {
            log.error("字符串转化失败：【{}】", e.getMessage());
        }
        return null;
    }
}
