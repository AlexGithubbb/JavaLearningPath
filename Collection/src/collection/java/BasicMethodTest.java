package collection.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BasicMethodTest {

    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add("A");
        coll.add("BB");
        coll.add("ccc");
        coll.add(333);
        coll.add(new Date());

        System.out.println(coll.size());
    }
}
