package collection.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BasicMethodTest {

    public static void main(String[] args) {
        Collection coll = new ArrayList();
         /* add() */
        coll.add("A");
        coll.add("BB");
        coll.add("ccc");
        coll.add(123);
        coll.add(new Date());

        /* size()*/
        System.out.println(coll.size()); // 5

        // create a new collection
        Collection coll1 = new ArrayList();

        coll1.add("d");
        coll1.add(456);
        coll1.add(456);

         /* addAll(collection coll1)*/
        coll.addAll(coll1);

        System.out.println(coll.size()); // 7

        System.out.println(coll);
        //[A, BB, ccc, 123, Sat May 02 11:53:52 EDT 2020, d, 456]

         /* isEmpty() */
        System.out.println(coll.isEmpty()); // false
    }

    @Test
    public void test1(){
        /* contains() */

    }
}
