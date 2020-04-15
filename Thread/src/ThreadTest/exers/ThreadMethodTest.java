package ThreadTest.exers;

/* 1. currentThread()
* 2. run()
* 3. start()
* 4. getName()
* 5. setName()
* 6. yield() ---> release current thread cpu memory
* 7. join() --> The join method allows one thread to wait for the completion of another.
*                If t is a Thread object whose thread is currently executing
* 8. sleep(time: ms) : causes the current thread to suspend execution for a specified period
* 9. isAlive()
* 10. stop: deprecated
*
*11. setPriority(  Thread.MAX_PRIORITY-> 10
*                   Thread.NORM_PRIORITY -> 5
*                   Thread.MIN_PRIORITY -> 1 )
*  High priority doesn't mean it will be executed totally firstly, just in high likely like this, but not absolutely is.
* */
public class ThreadMethodTest {
    public static void main(String[] args) {
        /* way 2: use constructor*/
        ThreadRandom1 t1 =  new ThreadRandom1("线程1");

        /* way1： use setName */
//        t1.setName("线程一");

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        /* set name for main thread*/
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100 ; i++) {
            if (i%2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
//            if (i == 33){
//                try {
//                    t1.join(); // pull thread t1 in;
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(t1.isAlive());
    }
}

class ThreadRandom1 extends Thread{

    public ThreadRandom1(String name) {
        super(name);
    }

    @Override
    public void run() {
        //
        for (int i = 0; i < 100 ; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
//            if(i % 10 == 0){
//                yield();
//            }
//            if(i == 44){
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}


