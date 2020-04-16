package ThreadTest.java;

public class RunnableTest {
    public static void main(String[] args) {
        MyRunThread myRunThread1 = new MyRunThread();
        Thread t1 = new Thread(myRunThread1);
        t1.setName("Thread-1");
        t1.start();

        Thread t2 = new Thread(myRunThread1);
        t2.setName("Thread-2");
        t2.start();


    }
}

class MyRunThread implements  Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if( i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
