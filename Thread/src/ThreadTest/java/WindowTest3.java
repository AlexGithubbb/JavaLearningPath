package ThreadTest.java;

public class WindowTest3 {

    public static void main(String[] args) {

        Window3 window1 = new Window3();

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
class Window3 implements  Runnable{

    public Window3() {
    }

    private int tickets = 100; // make it static to be shared with all instances

    Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (this){ // more simple way: use 'this'
//            synchronized (obj){ // the lock can be shared among threads if there is shared data, and the lock should be exactly the same for those threads.
                if(tickets > 0){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + " 售出票号: " + tickets);
                    tickets --;
                }else{
                    break;
                }
            }

        }
    }
}


