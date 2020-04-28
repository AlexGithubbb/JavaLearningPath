package compare.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*

comparable vs comparator :
comparable interface implemented on the class that any instance would be able to compare anywhere
comparator is more like temporarily add a tool at compare method to comapre the things



*/

public class CompareTest {
    /* String的包装类实现了comparable的接口, 可以重写compareTo(obj)方法
    *  当前对象this大于形参类的对象，return positive value, vise versa,
    * if returns 0, means they are equal on value
    * */
    @Test
    public void test(){
        String[] arr = new String[]{"AA", "ZZ", "LL", "QQ", "CC", "MM"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /* 自定义类，需要implements interface Comparable and override compareTo() */
    @Test
    public void test2(){
        Product[] mouses = new Product[3];

        mouses[0] = new Product("Dell", 300);
        mouses[1] = new Product("Apple", 120);
        mouses[2] = new Product("Lenovo", 120);


        Arrays.sort(mouses);
        System.out.println(Arrays.toString(mouses));
    }


    @Test
    public void comparatorTest3(){
        String[] arr = new String[]{"AA", "ZZ", "LL", "QQ", "CC", "MM"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw  new RuntimeException("unproper input type");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test3(){
        Product[] mouses = new Product[5];

        mouses[0] = new Product("Dell", 300);
        mouses[1] = new Product("Apple", 120);
        mouses[2] = new Product("Lenovo", 120);
        mouses[3] = new Product("Huawei", 141);
        mouses[4] = new Product("Huawei", 230);


        Arrays.sort(mouses, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Product && o2 instanceof  Product){
                    Product p1 = (Product) o1;
                    Product p2 = (Product) o2;
                    if(p1.getName().equals(p2.getName())){
                        return -Double.compare(p1.getPrice(), p2.getPrice());
                    }else{
                        return p1.getName().compareTo(p2.getName());
                    }
                }
                throw  new RuntimeException("wrong type exception");
            }
        });

        System.out.println(Arrays.toString(mouses));
    }

}
