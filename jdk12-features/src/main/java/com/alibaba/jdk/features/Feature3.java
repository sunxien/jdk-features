package com.alibaba.jdk.features;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 新特性3-数字格式化
 */
public class Feature3 {

    public void numberFormat() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println("NumberFormat: " + fmt.format(500000));
    }
}
