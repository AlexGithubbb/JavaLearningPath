package tutorial.java;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {

    @Test
    public void test(){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
             fis = new FileInputStream("test.txt");

            /* charset
             * what type of charset need to use, depends on in what way the srcFile saved.
             * if it's saved using UTF-8, then we need to use that as the charset
             *
             *  UTF-8 is set by default though
             * */
            // default
            isr = new InputStreamReader(fis);
//          isr = new InputStreamReader(fis, "UTF-8");
//            isr = new InputStreamReader(fis, "gbk"); // garbled

            int len;
            char[] cbuf = new char[10];

            while((len = isr.read(cbuf)) != -1){
               String data = new String(cbuf, 0, len);
                System.out.println(data);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* using InputStreamReader (utf8) && OutputStreamWriter (gbk) */
    @Test
    public void test2(){
        FileOutputStream fos = null;
        FileInputStream fis = null;

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {

            fis = new FileInputStream("test.txt");
            fos = new FileOutputStream("test_gbk.txt");
            isr = new InputStreamReader(fis);
            osw = new OutputStreamWriter(fos, "gbk");

            int len;
            char[] cbuf = new char[10];

            while( (len= isr.read(cbuf))!= -1){
                osw.write(cbuf, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if( osw!= null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
