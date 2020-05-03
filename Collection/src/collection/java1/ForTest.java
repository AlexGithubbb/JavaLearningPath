package collection.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("Alex"));
        coll.add("collection");
        Date date =  new Date();
        coll.add(date);
        coll.add(new Person("Coco", 24));


        // for(集合元素的类型 局部变量 ： 几个对象)
        // for( O o : collection) still uses iterator principle behind
        for(Object obj: coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        String[] str = new String[]{"MM", "MM", "MM"};

        // foreach loop
        for (String s : str){
            s = "GG";
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        System.out.println("\n-----------");

        // for loop
        for (int i = 0; i < str.length; i++) {
            str[i] = "GG";
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }




    }
}
