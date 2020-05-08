package map.java;

import collection.java1.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/* Map : 双层数据， 存储 key-value 对的数据 --- 类似于函数 y = f(x)
*   / ---- HashMap: 作为Map的主要实现类，线程不安全， 高效， 存储null的key and value
*       /---- LinkedHashMap:
*   /---- TreeMap:
*   /---- Hashtable: 作为古老的实现类， 线程安全，低效， 不能存null 的 key 和 value
*       /---- Properties: 常用来处理配置文件。 key value 均为String 类型
*
*
*
* HashMap的底层 : 数组 + 链表 （1.7之前）
*                数组 + 链表 + 红黑树 （jdk 1.8）
*
*
*
*  面试题：  1.HashMap 底层实现原理？
*           2. HashMap and Hashtable 的异同
*           3. currentHashMap && Hashtable 的 异同
*
* 二： Map 结构的理解：
*   Map中的 key ： 无序，不可重复， 使用Set存储所有的 key  --> key 所在的类要重写 equals() and hashCode()；（以HashMap 为例）
*   Map中的 value： 无序, 可重复， 使用 Collection 存储所有的 value ---> 所在类要重写 equals()
*   一个键值对： 构成了一个 Entry 对象
*   Map 中的 Entry ： 无序，不可重复，使用 Set 存储所有的 Entry
*
* */
public class MapTest {

    @Test
    public void test(){
        Map map = new HashMap<>();
//        map = new Hashtable(); // java.lang.NullPointerException
        map.put(null, null);
        map.put("key", "value");
        map.put(new Person("Tom", 34), "husband");

        System.out.println(map);

    }


    // JDBC test
/*    @Test
    public void test2(){

        try{
        // get connection
        Connectiion con = DriverManager.getConnection("sql://server name: prot/database name", "username", "password");

        // create statement
        Statement stat = con.createStatement();

        ResultSet rs = stat.executeQuery("selet * from database name");

        while(rs.next()){
            System.out.println(rs.getInt(1) + rs.getString(2));
            con.close();
        }}catch (Exception e){
            System.out.println(e);
        }

        //
    }*/
}
