package ThreadTest.java;


/*
 * 1. create 3 windows selling tickets
 * 2. there are tree windows with same ticket num: 100, is a security issue, and it's resolved
 *  by using unique synchronized obj(lock)
 * */
public class WindowTest1 {
    public static void main(String[] args) {

        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window1 extends Thread{

    private static int tickets = 100; // make it static to be shared with all instances

    private static Object obj = new Object(); // static obj is shared among all instances
    @Override
    public void run (){
            while (true) {
                /* can't wrap while(true), because one thread will keep staying inside the block until all 100 tickedts sold out., coz condition is always true  */
            synchronized (Window1.class) { // way1: obj; way 2: Window1.class --> the Class Window1, same to all instances, only load once
                if (tickets > 0) {
                    System.out.println(getName() + " 售出票号: " + tickets);
                    tickets--;
                } else {
                    break;
                }
            }
        }
    }
}

