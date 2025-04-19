package com.alibaba.jdk.features;

import java.io.Serializable;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 新特性3-Stream
 */
public class Feature3 {

    List<Employee> employees = Arrays.asList(
            new Employee(1, 121000, "Jack", "Male", 50000),
            new Employee(1, 121001, "Lucy", "Female", 55000),
            new Employee(2, 121002, "Peter", "Male", 47000),
            new Employee(3, 121003, "Pony", "Male", 51000),
            new Employee(2, 121004, "Robin", "Male", 52000),
            new Employee(1, 121005, "Tom", "Male", 44000),
            new Employee(1, 121006, "Eric", "Male", 58000),
            new Employee(2, 121007, "Lily", "Female", 60000),
            new Employee(3, 121008, "Steven", "Male", 54000),
            new Employee(3, 121009, "Owen", "Male", 55100),
            new Employee(1, 121010, "Ruby", "Female", 63000),
            new Employee(2, 121011, "Jackie", "Male", 66000),
            new Employee(2, 121012, "Mike", "Male", 66800),
            new Employee(3, 121013, "Tina", "Female", 49000),
            new Employee(1, 121014, "Lisa", "Female", 53800)
    );

    /**
     * Basic operations: filter, map, count, sum, iterate, limit, distinct, merge/concat
     * <p>
     * Stream can only be used once, otherwise it will throw
     * {@link java.lang.IllegalStateException: stream has already been operated upon or closed }
     */
    public void basicOperations() {
        // filter, map, count, sum
        List<Integer> list1 = Arrays.asList(1, -1, -3, 4, 5);
        OptionalInt min = list1.stream().filter(e -> e > 0).mapToInt(e -> e).min();
        OptionalInt max = list1.stream().filter(e -> e > 0).mapToInt(e -> e).max();
        int sum = list1.stream().filter(e -> e > 0).mapToInt(e -> e).sum();
        long count = list1.stream().filter(e -> e > 0).count();
        System.out.println("Min: " + min.orElseThrow(() -> new RuntimeException("No min")) + ", Max: " + max.orElseThrow(() -> new RuntimeException("No max")));
        System.out.println("Sum: " + sum + ", Count: " + count + ", Avg: " + ((double) sum / count));

        System.out.println("*".repeat(120));

        IntSummaryStatistics iss = list1.stream().filter(e -> e > 0).mapToInt(e -> e).summaryStatistics();
        System.out.println("Min: " + iss.getMin() + ", Max: " + iss.getMax());
        System.out.println("Sum: " + iss.getSum() + ", Count: " + iss.getCount() + ", Avg: " + iss.getAverage());

        System.out.println("*".repeat(120));

        // iterate, limit
        List<Integer> list2 = Stream.iterate(1, e -> e + 1).limit(10).toList();
        System.out.println("limit iterate: " + list2.stream().distinct().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println("*".repeat(120));

        // distinct
        List<Integer> list3 = Arrays.asList(1, -1, 1, 4, 6, 4, 7, 2, 9, 3, 7);
        System.out.println("distinct: " + list3.stream().distinct().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println("*".repeat(120));

        // merge/concat
        List<Integer> list4 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list5 = Arrays.asList(0, 2, 4, 6, 8);
        System.out.println("concat: " + Stream.concat(list4.stream(), list5.stream()).map(String::valueOf).collect(Collectors.joining(", ")));
    }

    /**
     * group by
     * group by + [count/min/max/avg]
     */
    public void groupByOperations() {

        // group by deptNo (WARN: group by key cannot be null)
        Map<Long, List<Employee>> groupByDeptMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e.depNo));
        for (Map.Entry<Long, List<Employee>> entry : groupByDeptMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("\t Employees: " + entry.getValue());
        }

        System.out.println("*".repeat(120));

        // group by deptNo and group by gender (WARN: group by key cannot be null)
        Map<Long, Map<String, List<Employee>>> groupByDeptAndGenderMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e.depNo,
                        Collectors.groupingBy(e -> e.gender)));
        for (Map.Entry<Long, Map<String, List<Employee>>> entry : groupByDeptAndGenderMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (Map.Entry<String, List<Employee>> entry2 : entry.getValue().entrySet()) {
                System.out.println("\t Gender: " + entry2.getKey());
                System.out.println("\t\t Employees: " + entry2.getValue());
            }
        }

        System.out.println("*".repeat(120));

        // group by and extract fields
        Map<Long, List<Long>> groupByDeptNoThenCollectFields = employees.stream().collect(
                Collectors.groupingBy(e -> e.depNo,
                        Collectors.mapping(e -> e.empNo, Collectors.toList())
                )
        );
        for (Map.Entry<Long, List<Long>> entry : groupByDeptNoThenCollectFields.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("\t Employees: " + entry.getValue());
        }

        System.out.println("*".repeat(120));

        // group by deptNo then counting
        Map<Long, Long> groupByDeptNoThenCounting = employees.stream().collect(
                Collectors.groupingBy(e -> e.depNo, Collectors.counting())
        );
        for (Map.Entry<Long, Long> entry : groupByDeptNoThenCounting.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("\t Employee Count: " + entry.getValue());
        }

        System.out.println("*".repeat(120));

        // group by deptNo then min/max/avg
        Map<Long, Employee> groupByDeptNoThenGetMaxSalaryEmployee = employees.stream().collect(
                Collectors.toMap(e -> e.depNo, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(e -> e.salary, Comparator.nullsLast(Integer::compareTo)
                        )))
        );
        for (Map.Entry<Long, Employee> entry : groupByDeptNoThenGetMaxSalaryEmployee.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("\t Employee(with Max Salary): " + entry.getValue());
        }

        System.out.println("*".repeat(120));

        Map<Long, Integer> groupByDeptNoThenGetMaxSalary = employees.stream().collect(
                Collectors.groupingBy(e -> e.depNo,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(e -> e.salary)),
                                a -> a.isPresent() ? a.get().salary : null
                        )
                )
        );
        for (Map.Entry<Long, Integer> entry : groupByDeptNoThenGetMaxSalary.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("\t Max(Salary): " + entry.getValue());
        }

        System.out.println("*".repeat(120));

        Map<Long, Double> groupByDeptNoThenAverageSalaryMap = employees.stream().collect(
                Collectors.groupingBy(e -> e.depNo,
                        Collectors.averagingInt(e -> e.salary))
        );
        for (Map.Entry<Long, Double> entry : groupByDeptNoThenAverageSalaryMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("\t Average(Salary): " + entry.getValue());
        }

        System.out.println("*".repeat(120));

        Map<Long, Integer> groupByDeptNoThenSummingSalaryMap = employees.stream().collect(
                Collectors.groupingBy(e -> e.depNo,
                        Collectors.summingInt(e -> e.salary))
        );
        for (Map.Entry<Long, Integer> entry : groupByDeptNoThenSummingSalaryMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            System.out.println("\t Summing(Salary): " + entry.getValue());
        }

        System.out.println("*".repeat(120));
    }

    public void list2Map() {
        // List to Map (with DUPLICATE KEY)
        Map<String, Employee> list2Map = employees.stream().collect(
                Collectors.toMap(e -> e.depNo + "-" + e.empNo,
                        Function.identity(), (k1, k2) -> k1 // If key duplicated, use first one
                )
        );
        for (Map.Entry<String, Employee> entry : list2Map.entrySet()) {
            System.out.println("Department-Employee: " + entry.getKey() + ", " + entry.getValue());
        }
    }

    public static class Employee implements Serializable {

        public long depNo;
        public long empNo;
        public String empName;
        public String gender;
        public int salary;

        public Employee(long depNo, long empNo, String empName, String gender, int salary) {
            this.depNo = depNo;
            this.empNo = empNo;
            this.empName = empName;
            this.gender = gender;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return empName + "(" + empNo + ")";
        }
    }
}
