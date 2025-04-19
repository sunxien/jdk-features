package com.alibaba.jdk.features;

import java.util.Optional;

/**
 * 新特性4-Optional
 */
public class Feature4 {

    /**
     * How to avoid `null`?
     * Don't use `of()`, `get()`, `flatMap()` methods.
     */
    public void optional() {
        // Difference between `of` and `ofNullable`?
        // => `of` cannot accept null, it will throw NPE
        // Optional<Object> of = Optional.of(null);

        Optional<Object> ofNullable1 = Optional.ofNullable(1);
        ofNullable1.ifPresent(System.out::println);

        // Sometimes use Optional.empty() instead of `Optional.ofNullable(null)`
        Optional<Object> ofNullable2 = Optional.ofNullable(null);
        // java.util.NoSuchElementException: No value present
        // ofNullable2.get();
        System.out.println(ofNullable2 == Optional.empty());

        // Use `orElseGet` to return a null replace value
        System.out.println(ofNullable2.orElseGet(() -> "Hello World"));
    }
}
