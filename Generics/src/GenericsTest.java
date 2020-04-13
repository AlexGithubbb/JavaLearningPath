//public class GenericsTest {
//    public static void main(String[] args) {
//        ArrayList arr = new ArrayList();
//
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add("item"); // error in run time
//        arr.add(4);
//
//        doubleItem(arr);
//    }
//
//    public static void doubleItem(ArrayList n){
//        for(Object i : n){
//            System.out.println((Integer) i * 2);
//        }
//    }
//}

import org.junit.Test;

import java.util.*;

public class GenericsTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<> (); // <> is called diamond

        arr.add(1);
        arr.add(2);
        arr.add(3);
//        arr.add("item"); // error in compile time, way better for dev
        arr.add(4);

        doubleItem(arr);
//
//        OrderPair<String, Integer> pair = new OrderPair<>("pwd", 123321);
//        System.out.println(pair.getKey());
//        System.out.println(pair.getValue());
    }

    public static void doubleItem(ArrayList<Integer> n){
        for(int i : n){
            System.out.println(i * 2);
        }
    }


    public static class Box<T>{
        private T t;

        public void setT( T t){
            this.t = t;
        }
        public T getT(){
            return t;
        }

        public static void main(String[] args) {
            Box<Integer> intBox = new Box<>();
            intBox.setT(333);
            System.out.println(intBox.getT());

            Box<String> strBox = new Box<>();
            strBox.setT("generics is quite good");
            System.out.println(strBox.getT());

        }
    }

    /* multiple type parameters */
    public interface Pair<K, V> {
        public K getKey();
        public V getValue();
    }

    public static class OrderPair<K, V> implements Pair<K, V>{

        public static void main(String[] args) {
            OrderPair<String, Box<Integer>> pair1 = new OrderPair<>("pwd", new Box<Integer>());

            pair1.getValue().setT(123);
            System.out.println(pair1.getKey());
            System.out.println(pair1.getValue().getT());

            OrderPair<String, String>  pair2 = new OrderPair<>("hello", "world");
            System.out.println(pair2.getKey());
            System.out.println(pair2.getValue());
        }

        private K key;
        private V value;

        public OrderPair(K key, V value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    @Test
    public void test1(){
        ArrayList scores = new ArrayList();
        scores.add(11);
        scores.add(12);
        scores.add(14);
        scores.add("common"); // error in run time !!!

        for(Object score : scores){
            // casting may cause some problems
            int stuScore = (int) score;
            System.out.println(score);
        }
    }

    // in method
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(14);
//        scores.add("common"); // error in compile time ~ ~ ~

        // method 1
//        for(int score : list){
//            // avoid the casting
//            int stuScore = score;
//            System.out.println(score);
//        }

        // method 2
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int score = iterator.next();
            System.out.println(score);
        }
    }

    // in collection
    @Test
    public void test3(){
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("Bob", 123);
        myMap.put("Alex", 322);
        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = myMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println("key: " + key + ", value: " + value);
        }
    }

}