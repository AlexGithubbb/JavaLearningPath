package listection.java1;/*
compare:
    ArrayList, : 线程不安全，效率高  (This class is roughly equivalent to
 * <tt>Vector</tt>, except that it is unsynchronized.) 底层使用 Object[] elementData 存储

    LinkedList： 对于频繁insert, remove， 使用此类比ArrayList 效率高， 底层使用双向链表创建

    Vector ： 线程安全， 效率低 ： jdk7和jdk8中， 通过Vector() 构造器创建对象时， 底层都创建了长度为10的数组。
    在扩容方面， 扩建为原来数组长度的2倍

*/


/*
* ArrayList 的对象创建模式为底层新建一个长度为10 的数组， 在添加元素长度超过10的时候，扩容一个1.5倍容量的数组，将原数组数据copy到新数组中，
    在 JDK1.7 && 1.8中创建顺序略有不同：
    1.7中是先创建数组再进行add() 操作，类似于单利的饿汉式
    1.8中先创建一个{},长度为0， 然后在调用 add() 时创建size==10的数组
    因此节省了内存空间，提高了效率， 类似于懒汉模式，延迟了数组的创建，节省内存
    *
    *
*/

/*

方法一览：

add(obj)
addAll(list)
remove()
set()
get()
indexOf()
subList()



常用方法：
增：add(obj)
删：remove(obj) / remove(index)
改：set(index, obj)
查：get(index)
插：add(index, obj)
长度：size()
遍历：① iterator 迭代器
     ② 增强for(obj: list){...}
     ③ normal for loop
*
*/

import collection.java1.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    // 遍历三种方法：
    @Test
    public void test3(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("Alex"));

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\n");
        for(Object obj: list){
            System.out.println(obj);
        }

        System.out.println("\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    // List 常用方法:
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(new String("Alex"));
        list.add(new Person("Coco", 24));

        System.out.println(list);
        // add(index, obj);
        list.add(2,7);
        System.out.println(list);

        // addAll(list)
        List<String> list1 = Arrays.asList("x", "y", "z");
        list.addAll(list1);
        System.out.println(list);

        // get(index)
        Object obj = list.get(0);
        System.out.println(obj);

        //indexOf()
        int i = list.indexOf("z");
        System.out.println(i == list.size()-1); // true
        System.out.println(i); // 7

        // lastIndexOf(obj)
        list.add(list.size(),123);
        System.out.println(list.lastIndexOf(123)); // 8

        // remove()
        Object removeObj = list.remove(0);
        System.out.println(removeObj);
        System.out.println(list);


        // set(index, obj)


        // subList(fromIndex, toIndex)
        Object subList = list.subList(4,7);
        System.out.println(subList);
        System.out.println(list);

    }


    @Test
    public void test1(){
        /* when the size is sure, we put the capacity as paramter to the constuctor */
        ArrayList list = new ArrayList(20);
        // the size will keep 0 until we run add()
        for (int i = 0; i < 20; i++) {
            list.add("a");
        }
        System.out.println(list.size());
    }



}
