package tutorial.java;

import org.junit.Test;

import java.io.*;

public class FileReaderWriter {
/*
* File 的实例化
*
* 常用构造器：
* File(String filepath)
* File(String parentPath, Stirng childPath)
* File(File parentFile, String childpat)
*
*
*   相对路径： 在 Junit 测试下使用的是相对路径（当前module下）
*   绝对路径： 在 main() 方法中调用的是绝对路径 （当前 project下）
*
* 1) read 的理解， 返回读入的字符，读到最后返回-1
* 2）为保证close() 能够顺利操作， 我们使用try catch() 而不是 throws
* 3）读入文件一定要存在， 否则会NullPointerException
*
*
*
*
* */

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            // 实例化File 对象
            File file = new File("hello.txt");
            System.out.println(file.getAbsoluteFile());

            // 提供具体的流, 流的实例化
            fr = new FileReader(file);

            // 数据读取
            // 如果达到文件末尾，返回 -1
//        int fd = fr.read();
            // 从第一个字节开始读取直到最后一个（返回 -1）
//        while(fd != -1){
//            System.out.println((char) fd);
//            fd = fr.read();
//        }

            // 代码优化
            int fd;
            while((fd = fr.read())!= -1){
                System.out.println((char) fd);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            // 流的关闭操作
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader1() throws IOException {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);

            char[] cbuf = new char[5];
            int len;

            while ((len = fr.read(cbuf)) != -1){
                /* Wrong syntax 1 */
//                for(int i =0; i < cbuf.length; i++) // use len, instead of cbuf.length
//                {
//                    System.out.println(cbuf[i]);
//                }
                /*  Wrong syntax 2 */
//                String str = new String(cbuf);
//                System.out.println(str);

                /*  correct syntax 1 */
//                for( int i = 0; i < len; i++ ){
//                    System.out.println(cbuf[i]);
//                }
                /*  correct syntax 2*/
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader2() throws IOException {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);

            char[] cbuf = new char[10];
            int len;

            while ((len = fr.read(cbuf)) != -1){
                String str = new String(cbuf, 0, len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
/*when write a file, a new file would be genearate if there is no such file created before
* if there is already a file :
*        FileWriter(file, true) -->  append: true -> add more content based on the original file
*        FileWriter(file, false) / FileWriter(file) --> append: false --> override the original one and create new content.
*  */
    @Test
    public void testFileWriter() throws IOException {
        File file = new File("hello1.txt");

        FileWriter fw = new FileWriter(file, true);

        fw.write("\ntoday's weather is pretty good, 2020.04.07\n");
        fw.write("how are you doing");

        // close the stream
        fw.close();
    }

    @Test
    public void TestFileReaderFileWriter() throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello2.txt");
            File desFile = new File("hello3.txt");

             fr = new FileReader(srcFile);
             fw = new FileWriter(desFile);

            int len;
            char[] cbuf = new char[6];
            while((len = fr.read(cbuf)) != -1){
                fw.write(cbuf, 0, len);
                String str = new String(cbuf, 0, len);
                System.out.println(str);

            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(fw != null)
                    fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            // if exception catched from fw, fr try catch still run, won't be affected
            try {
                if(fr != null)
                    fr.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }






}
