package tutorial.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {
    //    @Test
//    public void TestFileInputStreamOutputStream() {
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        try {
//            File srcFile = new File("tiger.jpeg");
//            File desFile = new File("tiger1.jpeg");
//
//             fis = new FileInputStream(srcFile);
//             fos = new FileOutputStream(desFile);
//
//            byte[] buffer = new byte[10];
//            int len;
//
//            while((len = fis.read(buffer)) != -1){
//                fos.write(buffer, 0, len);
//            }
//            System.out.println("picture copied!");
//        }catch (IOException e){
//            System.out.println("1");
//            e.printStackTrace();
//        }finally {
//            if(fos != null)
//            try {
//                    fos.close();
//            }catch (IOException e){
//                System.out.println("2");
//                e.printStackTrace();
//            }
//            if(fis != null)
//            try {
//                    fis.close();
//            }catch (IOException e){
//                System.out.println("3");
//                e.printStackTrace();
//            }
//
//        }
//        // create a new file object
//
//
//
//    }

    @Test
    public void testx() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            File srcFile = new File("nature.jpg");
            File desFile = new File("nature2.0.jpg");
            /*read file*/
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            /*create byte array*/
            int len;
            byte[] buffer = new byte[5];

            /*read and write byte buffer*/
            while( (len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            /*close the stream*/

            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }

    public void copyFileMethod(String srcPath, String desPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            File srcFile = new File(srcPath);
            File desFile = new File(desPath);
            /*read file*/
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            /*create byte array*/
            int len;
            byte[] buffer = new byte[1024];

            /*read and write byte buffer*/
            while( (len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            /*close the stream*/

            if(fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2(){
        String srcPath = "/Users/Alexpower/Desktop/memory1.mp4";
        String desPath = "/Users/Alexpower/Desktop/memory2.mp4";

        long start = System.currentTimeMillis();

        copyFileMethod(srcPath, desPath);

        long end = System.currentTimeMillis();

        System.out.println("time for copy the file:" + (end - start)); // 849 ms

    }
}
