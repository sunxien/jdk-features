package com.alibaba.jdk.features;

import java.util.Calendar;
import java.util.Random;

import static java.util.Calendar.*;

/**
 * 新特性4-增强switch
 */
public class Feature4 {

    public void enhanceSwitch() {
        int day = Math.abs(new Random().nextInt(6));
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
        }
    }
}
