package com.alibaba.jdk.features;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 新特性1-Collection
 */
public class Feature1 {


    public void newCollection() {
        List<Integer> list = List.of(1, 2, 3);
        System.out.println(list);
        // java.lang.UnsupportedOperationException
        // list.add(4);

        // java.lang.IllegalArgumentException: duplicate element: 2
        // Set<Integer> set = Set.of(1, 2, 3, 2, 1);
        Set<Integer> set = Set.of(1, 2, 3);
        System.out.println(set);

        Map<String, Integer> map = Map.of("one", 1, "two", 2, "three", 3);
        System.out.println(map);
    }

}
