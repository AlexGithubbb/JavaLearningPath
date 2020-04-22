package ThreadTest.java;


/* 使用同步方法的方式来做线程同步安全处理 ，
 * 在实现 Runnable 接口中应用 synchronized method(){...}, the lock is 'this' by default
 * 仍然需要同步监视器（🔐），只是被隐藏了，实际是 Window3plus.class
 * non static scynchronized method --> this
 * static synchronized --> 当前类本身
 *
 *
*/
public class WindowTest3plus {

    public static void main(String[] args) {

        Window3plus window1 = new Window3plus();

        Thread w1 = new Thread(window1);
        Thread w2 = new Thread(window1);
        Thread w3 = new Thread(window1);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
class Window3plus implements Runnable{

    public Window3plus() {
    }

    private int tickets = 100; // make it static to be shared with all instances

    @Override
    public void run() {
        while(true){
            sell();
        }
    }

    private synchronized void sell(){
//        synchronized (this){ // more simple way: use 'this'
//            synchronized (obj){ // the lock can be shared among threads if there is shared data, and the lock should be exactly the same for those threads.
            if(tickets > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println(Thread.currentThread().getName() + " 售出票号: " + tickets);
                tickets --;
            }
//        }
    }

}



