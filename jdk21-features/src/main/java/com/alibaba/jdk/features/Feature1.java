package com.alibaba.jdk.features;

/**
 *
 */
public class Feature1 {

    /// # Bad News:
    /// StringTemplate has been removed since JDK23
    public void stringTemplate() {
        // String name = "jack";
        // System.out.println(STR."Welcome {{name}}");
        // System.out.println(STR."Welcome ${name}");
    }
}
