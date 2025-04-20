package com.alibaba.jdk.features;

import java.util.stream.Gatherer;
import java.util.stream.Stream;
import java.util.HashSet;

/**
 *
 */
public class Feature3 {

    public void gatherStream() {
        var result = Stream.of("foo", "bar", "baz", "quux")
                .gather(Gatherer.ofSequential(
                        HashSet::new,
                        (set, str, downstream) -> {
                            if (set.add(str.length())) {
                                return downstream.push(str);
                            }
                            return true;
                        }
                ))
                .toList();
        System.out.println(result);
    }
}
