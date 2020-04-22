package ThreadTest.others;

import java.util.concurrent.locks.ReentrantLock;

/* ReentrantLock is another way just like synchronized()
二者都能解决线程安全问题
*  不同: it will unclock && lock mannualy (手动加锁解锁), not automatically like synchronized
*
* synchronized will auto release the lock when the synchronise code finished executed
*
* 优先使用顺序： Lock --> 同步代码块 （已经进入方法体， 分配了相应资源） --> 同步方法
* */
class Window implements Runnable {
    private int tickets = 100;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " sold :" + tickets);
                    tickets--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();

       Thread t1 = new Thread(window);
       Thread t2 = new Thread(window);
       Thread t3 = new Thread(window);

     t1.setName("线程A");
     t2.setName("线程B");
     t3.setName("线程C");

     t1.start();
     t2.start();
     t3.start();
    }
}