package tutorial.java;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CharCountTest {

    @Test
    public void test(){
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            Map<Character, Integer> map = new HashMap<>();

             fr = new FileReader("test.txt");
            int c = 0;

            while( (c = fr.read()) != -1){
                char ch = (char) c;

                if(map.get(ch) == null){
                    map.put(ch, 1);
                }else{
                    map.put(ch, map.get(ch) +1 );
                }
            }

             bw = new BufferedWriter(new FileWriter("charCount.txt"));

            // 遍历Map, 再写入数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for( Map.Entry<Character, Integer> entry : entrySet){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("space: "+ entry.getValue());
                        break;
                    case '\r':
                        bw.write("enter: "+ entry.getValue());
                        break;
                    case '\n':
                        bw.write("newLine: "+ entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab: "+ entry.getValue());
                        break;
                    default:
                        bw.write( entry.getKey() + "= "+ entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
