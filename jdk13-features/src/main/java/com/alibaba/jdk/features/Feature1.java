package com.alibaba.jdk.features;

/**
 * 新特性1-文本块
 */
public class Feature1 {

    public void textBlock(){
        String json = """
                {
                    "name":"mkyong",
                    "age":38
                }
                """;
        System.out.println(json);
    }
}
