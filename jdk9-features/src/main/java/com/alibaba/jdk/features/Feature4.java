package com.alibaba.jdk.features;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 新特性4-增强Stream和Optional
 */
public class Feature4 {


    public void newStream() {
        Stream<String> oneElementStream = Stream.ofNullable("One Element");
        System.out.println(oneElementStream.count());

        // JDK 1.8 unsupported null stream
        Stream<String> nullStream = Stream.ofNullable(null);
        System.out.println(nullStream.count());
    }


    public void highLevelOperations() {
        List<Integer> list1 = List.of(1, 3, 6, 8, 9, 7);

        String takeStr = list1.stream().takeWhile(x -> x < 5).map(e -> e + "").collect(Collectors.joining(", "));
        System.out.println("takeWhile: " + takeStr);

        String dropStr = list1.stream().dropWhile(x -> x < 5).map(e -> e + "").collect(Collectors.joining(", "));
        System.out.println("dropWhile: " + dropStr);

        // iterate
        String iterateStr1 = Stream.iterate(1, i -> i + 1).limit(10).map(e -> e + "").collect(Collectors.joining(", "));
        System.out.println("iterateStr1: " + iterateStr1);

        // iterate with Predicate functional-interface
        String iterateStr2 = Stream.iterate(1, i -> i <= 10, i -> i + 1).map(e -> e + "").collect(Collectors.joining(", "));
        System.out.println("iterateStr2: " + iterateStr2);

        //
        Optional<Object> emptyOptional = Optional.empty();
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("=> ifPresentOrElse: Empty Optional"));
        emptyOptional.or(() -> Optional.of("=> or(ifPresent): Default Optional")).ifPresent(System.out::println);
    }
}
