package tutorial.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {

    /* encrypt a picture file*/


    @Test
    public void test() {
        FileInputStream fis =null;
        FileOutputStream fos =null;
        try {
            fis = new FileInputStream("nature.jpg");
            fos = new FileOutputStream("nature_encrypt.jpg");

            // read the file
            int len;
            byte[] buffer = new byte[10];
            while ( (len = fis.read(buffer)) != -1){
                /*  wrong method
                    // this method doesn't encrypt buffer at all, just assign
                    // the encrypt byte to another var b; 从buffer中取出直接付给了新的变量b
                    for(byte b : buffer){

                       b = (byte) (b ^ 5);
                    }
                */
                // syco each byte
                for(int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5); // encryption
                }
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
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

    /* decrypt an encrypted picture file*/


    @Test
    public void test2() {
        FileInputStream fis =null;
        FileOutputStream fos =null;
        try {
            fis = new FileInputStream("nature_encrypt.jpg");
            fos = new FileOutputStream("nature_decrypt.jpg");

            // read the file
            int len;
            byte[] buffer = new byte[10];
            while ( (len = fis.read(buffer)) != -1){
                // syco each byte
                for(int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5); // decryption
                }
                fos.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fos != null){
                try {
                    fos.close();
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
