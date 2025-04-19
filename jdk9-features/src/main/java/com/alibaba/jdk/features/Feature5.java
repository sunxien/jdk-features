package com.alibaba.jdk.features;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;

/**
 * 新特性5-进程API
 */
public class Feature5 {

    public void newProcessHandle() {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("PID: " + currentProcess.pid());
        System.out.println("Process Info: " + currentProcess.info());
    }
}
