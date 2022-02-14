package com.example.demodegrade.degrade;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @descrip 容错
 * @author 兰建青
 * @date 2021/2/14
 **/
@Component
@Aspect
public class DegradeAspect {
    @Resource
    private ApplicationContext applicationContext;

    @Pointcut("@annotation(com.example.demodegrade.degrade.Degrade)")
    public void cacheRemoveAnnotationPointcut() {
        // TODO document why this method is empty
    }

    @Around("cacheRemoveAnnotationPointcut()")
    public Object methodsAnnotatedWithCacheRemove(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method joinPointMethod = methodSignature.getMethod();
        Degrade degrade = joinPointMethod.getAnnotation(Degrade.class);
        String className = degrade.className();
        if (!applicationContext.containsBean(className)) {
            throw new DegradeException("Spring找不到对应的Bean：" + className);
        }
        String methodName = degrade.methodName();

        return this.degrade(className, methodName, joinPoint);
    }

    private Object degrade(String className, String methodName, ProceedingJoinPoint joinPoint) throws Throwable {
        Object proxyObject = applicationContext.getBean(className);
        Method method = getMethod(proxyObject.getClass(), methodName);
        Class<?> target = AopUtils.getTargetClass(proxyObject);
        Method targetMethod = getMethod(target, methodName);
        if (Objects.isNull(targetMethod)) {
            throw new DegradeException(className + "没有【" + methodName + "】方法。");
        }
        Object[] args = joinPoint.getArgs();

        Object object;
        try {
            object = joinPoint.proceed();
        } catch (Throwable e) {
            object = Objects.requireNonNull(method).invoke(proxyObject, args);
        }
        return object;
    }

    /**
     * 获取目标方法
     * @param proxyObject 类对象
     * @param methodStr 类方法
     * @return Method
     */
    private Method getMethod(Class<?> proxyObject, String methodStr) {
        Method[] methods = proxyObject.getMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase(methodStr)) {
                return method;
            }
        }
        return null;
    }
}
