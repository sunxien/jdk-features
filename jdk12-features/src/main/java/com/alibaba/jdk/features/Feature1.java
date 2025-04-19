package com.alibaba.jdk.features;

/**
 * 新特性1-增强String
 */
public class Feature1 {

    public void enhanceString() {
        String text = "China";

        String intent4 = text.indent(4);
        System.out.println("[" + intent4 + "]");

        String intentNegTen = intent4.indent(-10);
        System.out.println("[" + intentNegTen + "]");

        String line = text.transform(e -> "I love " + e);
        System.out.println(line);
    }
}
