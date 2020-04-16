package ThreadTest.java;

/*
* 1. create 3 windows selling tickets
* 2. there are tree windows with same ticket num: 100, is a security issue, need to be resolved.
* */
public class WindowTest {
    public static void main(String[] args) {

        WindowThread window1 = new WindowThread();
        WindowThread window2 = new WindowThread();
        WindowThread window3 = new WindowThread();

        window1.setName("窗口一");
        window2.setName("窗口二");
        window3.setName("窗口三");

        window1.start();
        window2.start();
        window3.start();
    }
}

class WindowThread extends Thread{

    private static int tickets = 100; // make it static to be shared with all instances
    @Override
    public void run() {
        while(true){
            if(tickets > 0){
                System.out.println(getName() + " 售出票号: " + tickets);
                tickets --;
            }else{
                break;
            }
        }
    }
}
