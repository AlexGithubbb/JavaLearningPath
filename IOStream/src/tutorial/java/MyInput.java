package tutorial.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInput {
    public static String getStr(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static Number getNum(String str){
        return Integer.parseInt(getStr());
    }

}


