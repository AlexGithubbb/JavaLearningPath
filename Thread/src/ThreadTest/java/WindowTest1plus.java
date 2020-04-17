package ThreadTest.java;




/* 使用同步方法的方式来做线程同步安全处理 ，在继承Thread 方法中的应用 synchronized method(){...}, the lock is 'this' by default */

public class WindowTest1plus {

    public static void main(String[] args) {

        Window1plus w1 = new Window1plus();
        Window1plus w2 = new Window1plus();
        Window1plus w3 = new Window1plus();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window1plus extends Thread{

    private static int tickets = 100; // make it static to be shared with all instances

    private static Object obj = new Object(); // static obj is shared among all instances
    @Override
    public void run (){
        while (true) {
                sell();
            }

    }
    private static synchronized void sell(){
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + " 售出票号: " + tickets);
            tickets--;
        }
    }
}

