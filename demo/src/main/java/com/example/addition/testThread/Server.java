package com.example.addition.testThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月08日 13:10
 */
public class Server {

    private final ThreadPoolExecutor executor;

    public Server() {
//        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(16);
        executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void submit(Task task) {
        executor.execute(task);
        System.out.println("pool size==" + executor.getPoolSize());
        System.out.println("active count==" + executor.getActiveCount());
        System.out.println("complete count==" + executor.getCompletedTaskCount());
        System.out.println("\r");
    }

    public void endSever() {
        executor.shutdown();
    }
}
