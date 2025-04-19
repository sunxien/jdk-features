package com.alibaba.jdk.features;

import com.alibaba.fastjson2.JSON;

/**
 *
 */
public class Feature1 {

    public void newRecord(){
        Employee emp = new Employee(121001, "jack", 35, 100000, "13838385438");
        System.out.println(emp.age);
        System.out.println(emp);

        System.out.println(JSON.toJSONString(emp));
    }

    public static record Employee(long empId, String name
            , int age, int salary, String phone) {

    }
}
