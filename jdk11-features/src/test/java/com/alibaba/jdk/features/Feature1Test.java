package com.alibaba.jdk.features;

import org.junit.Test;

/**
 *
 */
public class Feature1Test {

    @Test
    public void test_http_client(){
        new Feature1().newHttpClient();
    }

}
