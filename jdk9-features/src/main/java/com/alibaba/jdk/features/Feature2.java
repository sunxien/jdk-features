package com.alibaba.jdk.features;

/**
 * 新特性2-String
 */
public class Feature2 {

    public void newString() {
        String str = new String("我❤️中国🇨🇳ILoveChina2025".getBytes());
        System.out.println(str);
        System.out.println("我❤️中国🇨🇳ILoveChina2025".equals(str));
    }
}
