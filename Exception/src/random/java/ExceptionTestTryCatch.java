package random.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTestTryCatch {

/*
*    try {
         // 可能出现异常的代码
*    }catch(异常类型1， 变量名1){
*       // 处理异常的方式1
*    }catch(异常类型2， 变量名2){
*       // 处理异常的方式2
*    }catch(异常类型3， 变量名3){
*       // 处理异常的方式3
*    }
*     ...
*     finally{
*       // 一定执行的代码
*       }

* */
@Test
public void test2(){
        try{
            File file = new File("test.txt");
            FileInputStream fis = new FileInputStream(file);
            int data = fis.read();
            while (data!= -1){
                System.out.println((char) data);
                fis.read();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
}

    @Test
    public void test1(){
        int[] arr = null;
        try{
            System.out.println(arr[0]);
            System.out.println("print 1");
        }catch(NullPointerException error){
            System.out.println("exception occurs. plz wait...");
            System.out.println("NullPointerException");

            // 两个常用的处理异常的方法 1 ： getMessage()
            // getMessage returns string
            String errorMessage = error.getMessage();
//            System.out.println(errorMessage);

            // 两个常用的处理异常的方法 2（更常用） ： printStackTrace()
            error.printStackTrace();



        }catch(NumberFormatException error){
            System.out.println("exception occurs. plz wait...");
            System.out.println("NumberFormatException");
        }catch(Exception error){
            System.out.println("Exception");
        }


    }
}
