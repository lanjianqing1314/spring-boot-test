package com.example.demolambda.functionalInterface;

/**
 * @author 兰建青
 * @title: Demo
 * @projectName spring-boot-test
 * @description: TODO
 * @date 2022/3/1222:15
 */
public class Demo {
    public static void main(String[] args) {
        BeseAcount add = (long a, long b) -> a + b;
        System.out.println(add.acount(1L, 2L));

        BeseAcount subtract = (long a, long b) -> a - b;
        System.out.println(subtract.acount(1L, 2L));

        BeseAcount multiply = (long a, long b) -> a * b;
        System.out.println(multiply.acount(1L, 2L));

        BeseAcount divide = (long a, long b) -> a / b;
        System.out.println(divide.acount(1L, 2L));
    }
}
