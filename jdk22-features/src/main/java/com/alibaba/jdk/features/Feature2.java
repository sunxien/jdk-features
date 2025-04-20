package com.alibaba.jdk.features;

import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

/**
 *
 */
public class Feature2 {

    /// # Bad News:
    /// java.util.concurrent.StructuredTaskScope is a preview API and may be removed in a future release
    public void scopeFork() {
        try (var scope = new StructuredTaskScope<>()) {
            StructuredTaskScope.Subtask<Integer> future1 = scope.fork(() -> {
                System.out.println("future1");
                return 1;
            });
            StructuredTaskScope.Subtask<String> future2 = scope.fork(() -> {
                System.out.println("future2");
                return "done";
            });
            try {
                scope.join();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /// # Bad News:
    /// java.lang.ScopedValue#newInstance is a preview API and may be removed in a future release
    public void scopeValue() {
        ScopedValue<String> v = ScopedValue.newInstance();
        ScopedValue.where(v, "abc").run(() -> {
            System.out.println(v);
        });
        // In a method called directly or indirectly from the lambda expression
        System.out.println(v.get());
    }
}
