package ThreadTest.exers;


/* 1. wait(), notify() and notify() all must be used in synchronized block or synchronized method
*  2. notify will release the prev lock.
*  3. wait, notify, notifyAll are all from Object
*
*
*  The common and differences between wait && sleep
* common:
*    1) both will stuck the thread
* difference:
*    1) sleep can be used in any cases, but wait() can only be used in synchronized method or block
*    2) Thread.sleep() && Object.wait()
*    3) sleep won't release the monitor but wait() will do
*
*
* */
public class WaitNotifyTest {
    public static void main(String[] args) {
        Count count = new Count();

        Thread t1 = new Thread(count);
        Thread t2 = new Thread(count);

        t1.setName("甲");
        t2.setName("乙");

        t1.start();
        t2.start();
    }
}

class Count implements Runnable{

    private int count = 1;
    @Override
    public void run() {

        while (true){
            count();
        }
    }

    public synchronized void count(){
        notify();
        if(count <= 100){
            System.out.println(Thread.currentThread().getName() + ": " + count);
            count ++;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* question about what if we use wait() and notify() in extending Thread way ???
    * code is down below
    *
    * */

//public class WaitNotifyTest {
//    public static void main(String[] args) {
//        Count t1 = new Count();
//        Count count2 = new Count();
//
//        t1.setName("甲");
//        count2.setName("乙");
//
//        t1.start();
//        count2.start();
//    }
//}
//
//class Count extends Thread{
//
//    private static int count = 1;
//    @Override
//    public void run() {
//
//        while (true){
//            count();
//        }
//    }
//
//    public synchronized void count(){
//
//            if(count <= 100){
//                System.out.println(Thread.currentThread().getName() + ": " + count);
//                count ++;
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//    }

}
