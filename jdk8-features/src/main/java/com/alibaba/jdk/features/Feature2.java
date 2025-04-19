package com.alibaba.jdk.features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 新特性2：函数接口
 * SAM（Single Abstract Method interfaces）有且只有一个抽象方法，但可以有多个非抽象方法的接口。
 * JDK 1.8 java.util.function 包中定义的接口都有 @FunctionalInterface 注解，支持函数式编程。
 */
public class Feature2 {

    /**
     * 1. Runnable interface
     * 2. Comparator interface
     * and any other functional interfaces.
     */
    public void insteadOfAnonymousInnerClass() {

        // New anonymous inner class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        }).start();

        // Use lambda expression
        new Thread(() -> System.out.println("It's a lambda function!")).start();

        // New anonymous inner class
        List<Integer> strings = Arrays.asList(1, 2, 3);
        Collections.sort(strings, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        // Uses lambda expression
        // Comparator<Integer> comparator = (Integer o1, Integer o2) -> o1 - o2;
        Collections.sort(strings, (Integer o1, Integer o2) -> o1 - o2);
    }

    /**
     * 1. No-arguments lambda interface
     * 2. One-argument lambda interface
     */
    public void customLambdaInterface() {
        // Lambda expression: () -> System.out.println("Hello World")
        print(() -> System.out.println("Hello World"));

        // Lambda expression: (int a, int b) -> a + b
        System.out.println(calculate(2, 3, (int a, int b) -> a + b));
    }

    public void print(NoArgsInterface inter) {
        inter.noArgs();
    }

    @FunctionalInterface
    public static interface NoArgsInterface {
        public abstract void noArgs();
    }

    public int calculate(int a, int b, TwoArgsInterface inter) {
        return inter.twoArgs(a, b);
    }

    @FunctionalInterface
    public static interface TwoArgsInterface {
        public abstract int twoArgs(int a, int b);
    }

    /**
     * Support `::` symbol call (static/instance) method.
     */
    public void useNewCallSymbol() {
        // 1. call static method, return type must be functional-interface
        NoArgsInterface ni1 = Feature2::getStaticFunctionalInterface;
        ni1.noArgs();

        // 2. call instance method, return type must be functional-interface
        NoArgsInterface ni2 = new Feature2()::getInstanceFunctionalInterface;
        ni2.noArgs();

        // 3. super::
        // 4. NoArgsInterface::
    }

    public static NoArgsInterface getStaticFunctionalInterface() {
        return () -> System.out.println("Use :: call static method");
    }

    public NoArgsInterface getInstanceFunctionalInterface() {
        return () -> System.out.println("Use :: call instance method");
    }

}
