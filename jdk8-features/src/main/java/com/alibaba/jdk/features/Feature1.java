package com.alibaba.jdk.features;

/**
 * 新特性1：Interface
 *
 * 1. 可以使用 `static` 关键字定义静态函数
 * 2. 可以使用 `default` 关键字定义实例方法
 * <p>
 * 面试题：抽象类（AbstractClass）和接口（Interface）的区别:
 * 1. 接口可以多实现，抽象类只能单继承
 * 2. 接口的方法默认只能是 public abstract 修饰，内部变量只能是 public static final 定义常量，抽象类可以用其他修饰符定义方法
 */
public interface Feature1 {

    /**
     * 定义静态函数
     */
    static void staticMethod() {
        System.out.println("static method defined in interface");
    }

    /**
     * 定义实例方法
     * 1. 可以使用 `this` 关键字调用
     * 2. 可以被子类重写接口默认逻辑
     */
    default void instanceMethod() {
        System.out.println("instance method defined in interface");
    }

    /**
     * 抽象方法需要被子类重写
     */
    public abstract void abstractMethod();

}
