package ThreadTest.others;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        NumCount numCount = new NumCount();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(numCount);

        Thread t1 =  new Thread(futureTask);

        t1.setName("counter 1");
        t1.start();


        try {
            int sum = futureTask.get();
            System.out.println("total sum is : "+ sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class NumCount implements Callable {
    public int sum = 0;
    @Override
    public Object call() throws Exception {
        for(int i = 0; i<= 100; i++){
            sum += i;
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
        return sum;
    }
}
