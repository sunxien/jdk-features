package com.alibaba.jdk.features;

/**
 * 新特性3-接口私有方法
 */
public class Feature3 {

    public static interface Printer {

        private void doPrint(String str) {
            System.out.println(str);
        }
    }
}
