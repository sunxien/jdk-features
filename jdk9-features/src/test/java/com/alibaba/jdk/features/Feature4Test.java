package com.alibaba.jdk.features;

import org.junit.Test;

/**
 *
 */
public class Feature4Test {

    @Test
    public void test_new_stream(){
        new Feature4().newStream();
    }

    @Test
    public void test_high_level_on_stream(){
        new Feature4().highLevelOperations();
    }
}
