package random.java;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

public class ExceptionTest {
    /****************** 以下是编译时异常  checked ******************/

//    @Test
//    public void test7(){
//        File file = new File("test.txt");
//        FileInputStream fis = new FileInputStream(file);
//
//            int data = fis.read();
//            while (data!= -1){
//                System.out.println((char) data);
//                fis.read();
//            }
//    }

    /****************** 以下是运行时异常  unchecked, RuntimeException ******************/
    @Test
    public void test1(){
        /* NullPointerException */
        int[] arr = null;
        System.out.println(arr[0]);
    }

    /*  IndexOutOfBoundsException  */
    @Test
    public void test2(){
        /* ArrayIndexOutOfBoundsException */
//        int[] arr = new int[5];
//        System.out.println(arr[5]);

        /* StringIndexOutOfBoundsException */
        String str = "hello";
        System.out.println(str.charAt(10));
    }

    /* ClassCastException */
    @Test
    public void test3(){

        //        convert string to int
        String numStr = "123";
        int x = Integer.parseInt(numStr);
        System.out.println(x); // return a primitive int

        int y = Integer.valueOf(numStr);
        System.out.println(y); // returns a Integer() object;

        Object target = new Date();
        String str = (String) target;
        System.out.println(str);
    }

    /* NumberFormatException */
    @Test
    public void test4(){
        String str = "10A";
        int x = Integer.valueOf(str);
        System.out.println(x);
    }

    /* InputMisMatchException */

    @Test
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(); // if user's input is not an integer, will pop up the exception
        System.out.println(x);
        scanner.close();
    }

    /* ArithmeticException */
    @Test
    public void test6(){
        int a = 9;
        int b = 0;
        System.out.println(a / b);
    }
}
