package ThreadTest.others;

import static java.lang.Thread.sleep;

public class DeadLock2 implements Runnable {
    B b = new B();
    A a = new A();

    public void init(){
        Thread.currentThread().setName("main thread");
        a.foo(b);
        System.out.println("entered the main thread");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("thread 1");
        b.bar(a);
        System.out.println("entered thread 1");
    }

    public static void main(String[] args) {
        /* start side thread */
        DeadLock2 dl = new DeadLock2();
        new Thread(dl).start(); // call run() method

        /* start main thread */
        dl.init();
    }
}

class A {
    public synchronized void foo(B b){ // monitor a
        System.out.println("current thread name: " + Thread.currentThread().getName() + ", entered foo() in class A");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("current thread name: " + Thread.currentThread().getName() + ", will enter last() in class B");
        b.last();
    }

    public synchronized void last(){ // monitor a
        System.out.println("current thread name: " + Thread.currentThread().getName() + ", entered last() in class A");
    };
}class B {
    public synchronized void bar(A a){ // monitor b
        System.out.println("current thread name: " + Thread.currentThread().getName() + ", entered bar() in class B");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("current thread name: " + Thread.currentThread().getName() + ", will enter last() in class A");
        a.last();
    }

    public synchronized void last(){ // monitor b
        System.out.println("current thread name: " + Thread.currentThread().getName() + ", entered last() in class B");
    };
}
