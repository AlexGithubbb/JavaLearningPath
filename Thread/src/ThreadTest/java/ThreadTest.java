package ThreadTest.java;

public class ThreadTest extends Thread{
    /*
    * 1.create subclass inherited from Thread
    * 2. override run method
    * 3. create instance
    * 4. use start() method to start the thread execution and call run() from Thread Class
    *
    * a) can not directly call run() to replace start(),
    * b) multi threads need to create multi instances to start with.
    * */

    /* iterate even nums within 100 */
        @Override
        public void run() {
            String tname = currentThread().getName();
            for(int i = 0; i < 100; i++){
                if(i %2 ==0)
                System.out.println(tname + ": " + i);
            }
        }

    public static void main(String[] args) {
        Thread t1 = new ThreadTest();
        Thread t2 = new ThreadTest();
        t1.start();
        t2.start();
        System.out.println("hello world");
        for(int i = 0; i < 100; i++){
            if(i %2 ==0)
                System.out.println(i  + "******** main() ******");
        }
    }


}
