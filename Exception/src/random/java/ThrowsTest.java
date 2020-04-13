package random.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
*   try..catch..finally 会真正处理异常
*   throws 只是将异常抛给了方法的调用者， 并没有把异常处理掉
*
* */

public class ThrowsTest {
    public static void main(String[] args) {
        try {
            method2();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("errors catch!");
        }
    }

    public static void method2() throws IOException {
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {
//        File file = new File("test.txt"); // not working, under project
        File file = new File("Exception/test.txt"); // works!
        System.out.println(file.getAbsoluteFile());
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data!= -1){
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
        System.out.println("hahaha");
    }

//    @Test
//    public void test(){
//        try {
//            File file = new File("test.txt"); // works, under module
//            FileInputStream fis = new FileInputStream(file);
//            int data = fis.read();
//            while (data!= -1){
//                System.out.println((char) data);
//                data = fis.read();
//            }
//            fis.close();
//            System.out.println("hahaha");
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
}
