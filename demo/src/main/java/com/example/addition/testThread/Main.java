package com.example.addition.testThread;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月08日 13:18
 */
public class Main {
    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 0; i < 10000; i++) {
            Task task = new Task("task--" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            server.submit(task);
        }

        server.endSever();
    }
}
