package ThreadTest.exers;
/* 两个储户分别向一个账户存3000， 分三次， 每次1000 ，每次存完打印余额 */

import java.util.concurrent.locks.ReentrantLock;

public class AccountTest {
    public static void main(String[] args) {
        Customer customer = new Customer();

        Thread a1 = new Thread(customer);
        Thread a2 = new Thread(customer);

        a1.setName("储户A");
        a2.setName("储户B");

        a1.start();
        a2.start();

    }
}

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void init (){
        this.balance = 0;
    }

    public void deposit(double newB){
        this.balance += newB;
    }

    public double getBalance(){
        return this.balance;
    }
}

class Customer implements Runnable{
    Account acc = new Account(333);

    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            lock.lock();
            for(int i = 0; i < 3; i++){
                acc.deposit(1000);
//                this.notify(); notify and wait can not be used in lock method
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 存了 1000" );
                System.out.println("账户余额： " + acc.getBalance());

            }
        }finally {
            lock.unlock();
        }
    }
}
