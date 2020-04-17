package ThreadTest.java;

/*
 * 1. create 3 windows selling tickets
 * 2. there are tree windows with same ticket num: 100, is a security issue, need to be resolved.
 * */

public class WindowTest2 {

    public static void main(String[] args) {

        Window2 window1 = new Window2();

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
class Window2 implements  Runnable{

    public Window2() {
    }

    private int tickets = 100; // make it static to be shared with all instances
    @Override
    public void run() {
        while(true){
            if(tickets > 0){
                System.out.println(Thread.currentThread().getName() + " 售出票号: " + tickets);
                tickets --;
            }else{
                break;
            }
        }
    }
}
