package tutorial.java;

import org.junit.Test;

import java.io.*;

public class BufferedTest {

    public void copyFileWithBuffered(String srcPath, String desPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;

        BufferedInputStream bis  = null;
        BufferedOutputStream bos = null;
        try{
            File srcFile = new File(srcPath);
            File desFile = new File(desPath);
            /*create 节点stream*/
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            /*create buffered stream 缓冲流（处理流的一种）*/
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            /*create byte array*/
            int len;
            byte[] buffer = new byte[1024];

            /*read and write byte buffer*/
            while( (len = bis.read(buffer)) != -1){
                bos.write(buffer, 0, len);
            }

            /*bos.flush() 刷新缓冲区*/
        }catch (
                IOException e){
            e.printStackTrace();
        }finally {
            /*close the outer stream is just fine, the inner stream will be closed auto*/

            if(bos != null){
                try {
                    bos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            if(bis != null){
                try {
                    bis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test1(){
        String srcPath = "/Users/Alexpower/Desktop/memory1.mp4";
        String desPath = "/Users/Alexpower/Desktop/memory2.mp4";

        long start = System.currentTimeMillis();
        copyFileWithBuffered(srcPath, desPath);
        long end = System.currentTimeMillis();

        System.out.println("time to copy file using buffered stream:" + (end - start)); // 440
    }

    @Test
    public void test2(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("hello.txt");
            File desFile  = new File("hello4.txt");

            // create buffered stream

             br = new BufferedReader(new FileReader(srcFile));
             bw = new BufferedWriter(new FileWriter(desFile));

             /*String method --> br.readLine() */
            String data;
            while((data = br.readLine() )!= null){
                bw.write(data);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}
    }
}
