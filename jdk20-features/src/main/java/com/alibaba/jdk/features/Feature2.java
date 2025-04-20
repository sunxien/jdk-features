package com.alibaba.jdk.features;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 *
 */
public class Feature2 {

    public void newVirtualThread() {
        // 1. Thread.ofVirtual
        Thread.Builder.OfVirtual v1 = Thread.ofVirtual();
        v1.name("virtual-thread-");
        v1.inheritInheritableThreadLocals(true);
        v1.start(() -> {
            System.out.println("ofVirtual");
        });

        // 2. Thread.startVirtualThread
        Thread v2 = Thread.startVirtualThread(() -> {
            System.out.println("startVirtualThread");
        });

        // 3. Executors.newVirtualThreadPerTaskExecutor
        var executors = Executors.newVirtualThreadPerTaskExecutor();
        executors.submit(() -> {
            System.out.println("newVirtualThreadPerTaskExecutor");
        });

        // 4. ThreadFactory
        Thread t4 = Thread.ofVirtual().factory().newThread(() -> {
            System.out.println("ofVirtual().factory()");
        });
        t4.start();
    }
}
