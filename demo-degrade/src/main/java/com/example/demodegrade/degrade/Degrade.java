package com.example.demodegrade.degrade;

import java.lang.annotation.*;

/**
 * @author ljq
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Degrade {
    String className();
    String methodName();
}

