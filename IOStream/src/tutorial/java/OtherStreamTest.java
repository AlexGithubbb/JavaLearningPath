package tutorial.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OtherStreamTest {

//    @Test
//    public void test() { // test in
public static void main(String[] args) {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
             br = new BufferedReader(isr);

            while(true){
                System.out.println("please insert your input chars");
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.out.println("program exit");
                    break;
                }

                String upd = data.toUpperCase();
                System.out.println(upd);
            }


        }catch (IOException e){
            e.printStackTrace();
        }finally {
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
