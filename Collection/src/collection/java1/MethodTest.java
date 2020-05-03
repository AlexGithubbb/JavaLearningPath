package collection.java1;

import org.junit.Test;

import java.util.*;

public class MethodTest {

    @Test
    public void test() {
        System.out.println("********************");

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("Alex"));
        coll.add("collection");
        coll.add(new Date());

        /* when we add the data into the obj which implements Collection,
           we needs to override equals() in Person
        */
        Person p = new Person("Jerry", 13);
        coll.add(p);
        coll.add(new Person("Coco", 24));

        /* contains() */
        System.out.println(coll.contains(123)); // true
        System.out.println(coll.contains(p)); // true

        // false --> true : after override equals method in Person

        System.out.println(coll.contains(new Person("Coco", 24)));

    }
    @Test
    public void test2(){
        System.out.println("********************");
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("Alex"));
        coll.add("collection");
        coll.add(new Person("Jerry", 13));

        /* containsAll()*/
        Collection coll1 = Arrays.asList(123, "collection");
        System.out.println(coll.containsAll(coll1)); // true

        /* remove() , returns a boolean value */
        coll.addAll(coll1);
        System.out.println(coll.remove("collection")); // true
        coll.remove(new Person("Jerry", 13));
        System.out.println(coll);

        /*removeAll() , only remove the common element (123, 123) */
        coll.removeAll(Arrays.asList(123, 123, 321));
        System.out.println(coll);
    }

    @Test
    public void test3(){
        /* retainAll() , get the shared/ common parts and return it to the current collection */
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("Alex"));
        coll.add("collection");
        coll.add(new Person("Jerry", 13));
        coll.add(false);

//        coll.retainAll(Arrays.asList(123,"collection", "amazing"));
//        System.out.println(coll);

        /* equals(Object object) , as long as the element && the order are all same (in terms of Collection)  */
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(new String("Alex"));
        coll1.add("collection");
        coll1.add(new Person("Jerry", 13));
        coll1.add(false);

        System.out.println(coll.equals(coll1)); // true


    }

    @Test
    public void test4(){
        /* toArray() : collection --> array */
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("Alex"));
        coll.add("collection");
        coll.add(new Person("Jerry", 13));
        coll.add(false);

        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        /* Arrays.asList() : array --> collection */

        List list = Arrays.asList(arr);
        System.out.println(list);

        List list1 = Arrays.asList(new int[]{123,456});
        System.out.println(list1); // [[I@deb6432] ;size = 1

        List list2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(list2); // [123, 456] ; size = 2

    }

    @Test
    public void test5(){

    }
}
