package com.alibaba.jdk.features;

import org.junit.Test;

/**
 *
 */
public class Feature3Test {


    @Test
    public void test_stream_basic_operations() {
        new Feature3().basicOperations();
    }


    @Test
    public void test_stream_group_by_operations() {
        new Feature3().groupByOperations();
    }
}
