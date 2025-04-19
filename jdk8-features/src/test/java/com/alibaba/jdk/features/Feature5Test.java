package com.alibaba.jdk.features;

import org.junit.Test;

/**
 * @author sunxien
 * @date 2025/4/19
 * @since 1.0.0-SNAPSHOT
 */
public class Feature5Test {

    @Test
    public void test_new_datetime(){
        new Feature5().newDateTime();
    }

    @Test
    public void test_string_to_datetime(){
        new Feature5().string2DateTime();
    }

    @Test
    public void test_datetime_to_datetime(){
        new Feature5().calcDateTime();
    }

    @Test
    public void test_get_some_datetime(){
        new Feature5().getSomeDay();
    }
}
