package com.alibaba.jdk.features;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 新特性1-类型推导
 */
public class Feature1 {

    public void typeInfer() throws Exception {
        var id = 0;
        var baidu = new URL("https://www.baidu.com");
        var empties = new ArrayList<>();
        var list = List.of(1, 2, 3);
        var map = new HashMap<String, String>();
        var p = Paths.get("src/test/resources/note.txt");
        var numbers = List.of("a", "b", "c");

        // Compile error:  null  is unsupported
        // var count=null;

        // Compile error: Lambda expression is unsupported
        // var r = () -> Math.random();

        // Compile error: array is unsupported
        // var array = {1,2,3};
    }
}
