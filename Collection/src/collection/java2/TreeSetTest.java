package collection.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    /*
    * 1. all data should be at same type in TreeSet()
    * 2. two sorting method ： 自然排序 (实现comparable 接口) 和 定制排序
    * 3. 自然排序中， 比较两个对象是否相同的标准为： compareTo() 返回0， 不再是equals()
    * 4. 定制排序中， 比较两个对象是否相同的标准为： compare()/compareTo() 返回0， 不再是equals()
    * */


    @Test
    public void test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User user1 = (User) o1;
                    User user2 = (User) o2;
//                    return Integer.compare(user1.getAge(), user2.getAge());
                    int compareName = user1.getName().compareTo(user2.getName());
                    int compareAge = Integer.compare(user1.getAge(), user2.getAge());

                    if(compareName != 0){
                        return compareName;
                    }else{
                        return compareAge;
                    }
                }else{
                    throw new RuntimeException("different types are not comparable");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("tom", 23));
        set.add(new User("jerry", 13));
        set.add(new User("alex", 27));
        set.add(new User("sam", 24));
        set.add(new User("sam", 51));
        set.add(new User("sam", 51));

        Iterator iterator = set.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test() {
        TreeSet set = new TreeSet();
        // failed, diff types are not allowed
//        set.add(123);
//        set.add(45);
//        set.add(false);
//        set.add(new Person("Tom", 65));
//        set.add(new User("hacker", 21));
//        set.add(new User("hacker", 21));
//        set.add(null);

//        set.add(123);
//        set.add(-45);
//        set.add(4);
//        set.add(4565);


//        set.addAll(Arrays.asList("bamboo", "apple", "cart"));


        set.add(new User("tom", 23));
        set.add(new User("jerry", 13));
        set.add(new User("alex", 27));
        set.add(new User("sam", 24));
        set.add(new User("sam", 51)); // 需要在User里加一个年龄排序，否则只显示一个sam



        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
