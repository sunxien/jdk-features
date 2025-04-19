package com.alibaba.jdk.features;

/**
 * 新特性1-增强Switch
 */
public class Feature2 {

    public void enhanceSwitch() {
        String name = "Boy";
        // return will jump out this method, but yield will not
        String result = switch (name) {
            case "Boy":
                yield "you are a handsome boy!";
            case "Girl":
                yield "you are a beautiful girl!";
            default:
                yield name + " may be a old man!!!";
        };
        System.out.println("switch(yield): " + result);
    }
}
