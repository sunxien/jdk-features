package com.alibaba.jdk.features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * JDK 1.8 java.util.stream 包定义流（Stream），Stream 不存储任何数据，它可以提取（Retrieve）和其他逻辑处理、包括筛选、排序、统计、计数等。
 * 它的源可以是集合（Collection）、数组（Array）等。一般它的方法参数都提供函数式接口类型，所以建议和 Lambda 配合使用。
 */
public class Feature3 {

    /**
     * Basic operations: filter, map, count, sum, iterate, limit, distinct, merge/concat
     * <p>
     * Stream can only be used once, otherwise it will throw
     * {@link java.lang.IllegalStateException: stream has already been operated upon or closed }
     */
    public void basicOperations() {
        // filter, map, count, sum
        List<Integer> list1 = Arrays.asList(1, -1, -3, 4, 5);
        int sum = list1.stream().filter(e -> e > 0).mapToInt(e -> e).sum();
        long count = list1.stream().filter(e -> e > 0).count();
        System.out.println("Sum: " + sum + ", Count: " + count + ", Avg: " + (sum / count));

        IntSummaryStatistics iss = list1.stream().filter(e -> e > 0).mapToInt(e -> e).summaryStatistics();
        System.out.println("Min: " + iss.getMin() + ", Max: " + iss.getMax() + iss.getAverage());
        System.out.println("Sum: " + iss.getSum() + ", Count: " + iss.getCount() + ", Avg: " + iss.getAverage());

        // iterate, limit
        List<Integer> list2 = Stream.iterate(1, e -> e + 1).limit(10).toList();
        list2.forEach(System.out::println);

        // distinct
        List<Integer> list3 = Arrays.asList(1, -1, 1, 4, 6, 4, 7, 2, 9, 3, 7);
        list3.stream().distinct().toList().forEach(System.out::println);

        // merge/concat
        List<Integer> list4 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list5 = Arrays.asList(0, 2, 4, 6, 8);
        List<Integer> list45 = Stream.concat(list4.stream(), list5.stream()).toList();
        list45.forEach(System.out::println);
    }

    /**
     * group by
     * group by + [count/min/max/avg]
     */
    public void groupBy() {
        
    }
}
