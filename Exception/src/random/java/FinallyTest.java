package random.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyTest {
/*
*
*   try..catch 用于有编译时异常的情况下
*   如果异常本身在编译时没有，在运行时出现，此情况没有必要加 try catch
*
*
*
* */
    @Test
    public void test3(){
        FileInputStream fis = null;
        try{
            File file = new File("test.txt");
            fis = new FileInputStream(file);
            int data = fis.read();
            while (data!= -1){
                System.out.println((char) data);
                data = fis.read();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace(); // FileNotFoundException
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fis != null) // avoid NullPointerException
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        int x = method();
        System.out.println(x);
    }
    public int method(){
        try {
            int[] arr = new int[10];
//            System.out.println(arr[10]);
            return 1;
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return 2;
        }finally {
            System.out.println("这里一定执行！");
            return 3;
        }

    }

    @Test
    public void test1(){
        try {
            int a = 9;
            int b = 0;
            System.out.println(a/b);
        }catch (ArithmeticException error){
            error.printStackTrace();
            System.out.println("catch");
            int[] arr = new int[10];
            System.out.println(arr[10]);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("这里一定执行！");
    }
    }
}
