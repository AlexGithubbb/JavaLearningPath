package ThreadTest.exers;

//public class ThreadDemo {
//
//    public static void main(String[] args) {
//        MyThread1 t1 = new MyThread1();
//        MyThread2 t2 = new MyThread2();
//        t1.start();
//        t2.start();
//    }
//}
//
///* syntax 1 */
//class MyThread1 extends Thread{
//    @Override
//    public void run() {
//        for(int i = 0; i < 100 ; i++){
//            if(i % 2 == 0){
//                System.out.println(Thread.currentThread().getName() + ": " + i);
//            }
//        }
//    }
//}
//class MyThread2 extends Thread{
//    @Override
//    public void run() {
//        for(int i = 0; i < 100 ; i++){
//            if(i % 2 != 0){
//                System.out.println(Thread.currentThread().getName() + ": " + i);
//            }
//        }
//    }
//}


/* syntax 2
* use Thread anonymous subclass way
* */
public class ThreadDemo {

    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 100 ; i++){
                if(i % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 100 ; i++){
                    if(i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

    }
}
