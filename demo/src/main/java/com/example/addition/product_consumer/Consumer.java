package com.example.addition.product_consumer;


/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月07日 19:17
 */
public class Consumer implements Runnable {
    Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        Product product = storage.get();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
