package tutorial.java;

import java.io.*;

/* This small project can be used when user wants to save what they type in
(using BufferedReader.readLine()) to a local file.
* */
public class PrintStreamTest {
//    @Test
//    public void test(){
    public static void main(String[] args) {
        System.out.println("please insert your data");

        PrintStream ps = null;
    try {
        FileOutputStream fos = new FileOutputStream(new File("/Users/Alexpower/Desktop/test.txt"));
        ps = new PrintStream(fos, true);
        if(ps != null){
            System.setOut(ps);
        }

//            for(int i= 0; i <= 255; i++){
//                System.out.println((char) i);
//                if(i % 50 == 0){
//                    System.out.println();
//                }
//            }

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true){
            String data = br.readLine();
            System.out.println(data);
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                System.out.println("program exit");
                break;
            }
        }

    }catch (IOException e){
        e.printStackTrace();
    }finally {
        if(ps != null){
            ps.close();
        }

    }
}
}
