package com.example.addition.testThread;

public class TestThread {
    volatile private int t1;
    volatile private int t2;

    synchronized public void setT1(int t1) {
        System.out.println("set t1=" + t1);
        this.t1 = t1;
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void setT2(int t2) {
        System.out.println("set t2=" + t2);
        this.t2 = t2;
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void sum() {
        if (t1 != 0 & t2 != 0) {
            System.out.println("sum=" + (t1 + t2));
            t1 = 0;
            t2 = 0;
        }
        notifyAll();
    }

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("threadG");

        Thread thread3 = new Thread(threadGroup, "ppThread");

        TestThread testThread = new TestThread();
        Thread thread = new Thread(new A(testThread));
        Thread thread1 = new Thread(new B(testThread));
        Thread thread2 = new Thread(new C(testThread));

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class A implements Runnable {
    TestThread testThread;

    public A(TestThread testThread) {
        this.testThread = testThread;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testThread.setT1(i++);

        }
    }
}


class B implements Runnable {
    TestThread testThread;

    public B(TestThread testThread) {
        this.testThread = testThread;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testThread.setT2(i++);
        }
    }
}

class C implements Runnable {
    TestThread testThread;

    public C(TestThread testThread) {
        this.testThread = testThread;
    }

    @Override
    public void run() {
        while (true)
            testThread.sum();
    }
}