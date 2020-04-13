package practice.java;

public class ExceptionPractice1 {
    static void methodA(){
        try {
            System.out.println("enter method A");
            throw new RuntimeException("create an exception in method A");
        }finally {
            System.out.println("finally method A");
        }
    }
    static void methodB(){
        try {
            System.out.println("enter method B");
            return;
        }finally {
            System.out.println("finally method B");
        }
    }

    public static void main(String[] args) {
//        ExceptionPractice1 test = new ExceptionPractice1();
        try {
            methodA();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("***************************");
        methodB();
    }


}
