package ThreadTest.others;

public class BankTest {

}

class Bank {
    private Bank(){}

    private static Bank instance = null;
/* way 1
    public synchronized static Bank getInstance(){
    */
public static Bank getInstance() {
    // way 1
//        synchronized (Bank.class){
//            if(instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

    // way 2, more efficient, if it's null, get in, if it's not, other threads won't get in
    if (instance == null) {
        synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
        }
    }
    return instance;
}
    /* way 2*/
}
