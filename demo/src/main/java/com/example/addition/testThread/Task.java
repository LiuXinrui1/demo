package com.example.addition.testThread;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月08日 13:13
 */
public class Task implements Runnable {
    String taskId;

    public Task(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(taskId);
    }
}
