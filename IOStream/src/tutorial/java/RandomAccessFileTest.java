package tutorial.java;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    @Test
    public void test() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
                 raf1 = new RandomAccessFile("nature.jpg", "r");
                 raf2 = new RandomAccessFile("nature1.jpg", "rw");

                int len;
                byte[] buffer = new byte[1024];
                while ((len = raf1.read(buffer)) != -1){
                    raf2.write(buffer, 0, len);
                }

            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(raf2 != null){
                    try {
                        raf2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(raf1 != null){
                    try {
                        raf1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        /*if RandomAccessFile used as an output Stream, if the des file doesn't exist, then it will create a new file,
        * if it does exist, then will cover from the beginning, like 'xyz' covers the 'abc'
        * */
    @Test
    public void test2() {

            RandomAccessFile raf2 = null;
            try {
                raf2 = new RandomAccessFile("randomTest.txt", "rw");

                raf2.seek(3); // put the index to 3
                raf2.write("xyz".getBytes());

            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(raf2 != null){
                    try {
                        raf2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }

}
