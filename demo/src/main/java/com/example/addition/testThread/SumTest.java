package com.example.addition.testThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月08日 13:55
 */
public class SumTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        try {
            int i = 0;
            List<Future<Integer>> list = new ArrayList<>();
            while (i < 10000) {
                i++;
                Future<Integer> submit = executorService.submit(new Task2());
                list.add(submit);
            }


            do {
                for (int j = 0; j < list.size(); j++) {
                    Future<Integer> future = list.get(j);
                    System.out.println(future.isDone());
                }
            } while (executorService.getCompletedTaskCount() < list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
