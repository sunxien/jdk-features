package com.alibaba.jdk.features;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 新特性2-String
 */
public class Feature2 {


    public void new_string_sdk() {
        boolean blank = " ".isBlank();
        System.out.println("isBlack: " + blank);

        String strip = " CHINA ".strip();
        System.out.println("strip: " + "CHINA".equals(strip));

        String stripLeading = " CHINA ".stripLeading();
        System.out.println("stripLeading: " + ("CHINA ".equals(stripLeading)));

        String trailing = " CHINA ".stripTrailing();
        System.out.println("stripTrailing: " + (" CHINA".equals(trailing)));

        String repeat = "CHINA".repeat(3);
        System.out.println("repeat 3 times: " + repeat);

        long lines = "CHINA\nCHINA\nCHINA".lines().count();
        System.out.println("lines(count): " + (lines == 3));

        List<String> list = "CHINA\nCHINA\nCHINA".lines().toList();
        System.out.println("lines(toList): " + (list.size() == 3));
    }
}
