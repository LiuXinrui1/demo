package com.example.addition.testThread;

import java.util.concurrent.Callable;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月08日 15:18
 */
public class Task2 implements Callable {
    static int i;

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return i++;
    }
}
