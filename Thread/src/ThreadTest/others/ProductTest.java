package ThreadTest.others;

/* producer , clerk, customer : clerk can only serve 20 products, if there's more than 20,
* will call producer to stop producing, if it's no product, will let customer wait.
*
*
*  */
public class ProductTest {
    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Customer customer = new Customer(clerk);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(customer);
        Thread t3 = new Thread(customer);

        t1.setName("生产者");
        t2.setName("消费者1");
        t3.setName("消费者2");

        t1.start();
        t2.start();
        t3.start();


    }
}

class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // produce the product
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}


class Customer implements  Runnable{

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        // buy the product
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }
    }
}

class Clerk {

    private int products = 0;

    public synchronized void produce(){ // 握住 Clerk 的对象 clerk , 唯一的
        if(products < 20){
            products ++;
            System.out.println(Thread.currentThread().getName() +"正在生产第 " + products + " 个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void consume(){ // 握住 Clerk 的对象 clerk , 唯一的
        if(products >0){
            System.out.println(Thread.currentThread().getName() +"正在消费第 " + products + " 个产品");
            products --;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

