package com.example.addition.product_consumer;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2020年06月07日 19:13
 */
public class Producer implements Runnable {
    Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            Product product = new Product(i++, Thread.currentThread() + "");
            storage.push(product);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
