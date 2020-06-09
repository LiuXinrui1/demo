package com.example.addition.product_consumer;

import com.example.addition.product_consumer.Product;

public class Storage {
    private Product[] products = new Product[10];

    private int top = 0;

    public synchronized void push(Product product) {
        if (top < products.length) {
            products[++top] = product;
            System.out.println(Thread.currentThread().getName() + "--push a product into storage");
            notifyAll();
        } else {
            System.out.println("can not push cause storage out");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized Product get() {
        if (top > -1) {
            Product product1 = products[top];
            products[top--] = null;

            System.out.println(Thread.currentThread().getName() + "--get a product " + product1.getId() + "from storage");
            notifyAll();
            return product1;
        } else {
            System.out.println("has no product to get");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
