package com.example.addition;

public class TestApacheHttpClient {
    public static void main(String[] args) throws ClassNotFoundException {
        TestRunnable testRunnable = new TestRunnable();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();
        new Thread(testRunnable).start();


    }
}

class TestRunnable implements Runnable {

    private volatile int num = 100;
    String s = "";

    @Override
    public void run() {
        while (true) {
            sale();
        }
    }

    synchronized void sale() {
        if(num>0){
            num--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----"+num);
        }
    }
}