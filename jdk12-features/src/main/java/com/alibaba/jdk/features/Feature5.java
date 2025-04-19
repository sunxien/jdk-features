package com.alibaba.jdk.features;

/**
 * 新特性5-增强instanceof
 */
public class Feature5 {

    public void enhanceInstanceOf() {
        Object obj = "I love China";
        if (obj instanceof String str) {
            System.out.println(str);
        }
    }
}
