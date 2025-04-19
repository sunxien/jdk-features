package com.alibaba.jdk.features;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 新特性2-增强Files
 */
public class Feature2 {

    public void enhanceFiles() {
        Path one = Paths.get("src/test/resources/1.txt");
        Path two = Paths.get("src/test/resources/2.txt");
        long mismatched = -1;
        try {
            mismatched = Files.mismatch(one, two);
            System.out.println("mismatch: " + mismatched);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
