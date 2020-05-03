package collection.java1;

import org.junit.Test;

import java.util.*;

public class IteratorTest {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("Alex"));
        coll.add("collection");
        coll.add(new Date());
        coll.add(new Person("Coco", 24));

        Iterator iterator = coll.iterator();

        /* method 1*/
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
//         exception :
//         NoSuchElementException
//        System.out.println(iterator.next());

        /* method 2 , not recommend */
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        /* method 3 */
        System.out.println("\n**************");
        Iterator iter = coll.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        /* wrong method 1
        *  escape the first , third ... one and will get NoSuchElementException
        * */
//        while(iterator.next() != null){
//            System.out.println(iterator.next());
//        }

        /* wrong method 2
        * dead loop, always prints 123, it will generate a new interator obj everytime we call iterator()
        * */
//        while(coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(new String("Alex"));
        coll.add("collection");
        Date date =  new Date();
        coll.add(date);
        coll.add(new Person("Coco", 24));


        Iterator iter = coll.iterator();
        while(iter.hasNext()){
            Object obj = iter.next();
            // remove "collection" and "date"
            if("collection".equals(obj) || date.equals(obj) ){
                System.out.println("collection".equals(obj));
                iter.remove();
//                System.out.println(coll);
            }
        }


        /* remove() */
        // generate new iterator
        Iterator iter1 = coll.iterator();
        while(iter1.hasNext()){
            System.out.println(iter1.next());
        }
    }

}
