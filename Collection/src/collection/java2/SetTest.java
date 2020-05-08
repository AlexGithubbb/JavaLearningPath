package collection.java2;

import collection.java1.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

    /*
    Set: 存储无序的，不可重复的数据
    无序： 不是随机，存储的数据在底层数组中并非按照数组索引的顺序添加， 而是根据数据的hashCode 进行排序
    不可重复性： 保证添加的元素按照equals()判断时， 不能返回 true, 即： 相同的元素只能添加一个。


    * HashSet --> 添加在HashSet 中的对象 必须在该父类中 override equals() and hashCode()，
        Tips： fields being used in equals() should also be used in hashCode()

    * LinkedSet  --> 在添加数据的同时，创建了两个引用， 维护了数据的添加顺序(前后两个区域 prev, next)，
                    在频繁遍历的情况下保持了高效率

    * TreeSet --> 可以按照添加对象的指定属性进行排序
    *  */

public class SetTest {
    @Test
    public void test(){
        Set set = new HashSet();
        set.add(123);
        set.add(45);
        set.add(false);
        set.add(new Person("Tom", 65));
        set.add(new User("hacker", 21));
        set.add(new User("hacker", 21));
        set.add(null);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    // LinkedHashSet
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(45);
        set.add(false);
        set.add(new Person("Tom", 65));
        set.add(new User("hacker", 21));
        set.add(new User("hacker", 21));
        set.add(null);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }


}
