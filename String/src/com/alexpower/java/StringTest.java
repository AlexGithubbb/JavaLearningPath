package com.alexpower.java;

import org.junit.Test;

public class StringTest {


    /*  String: 字符串， 用""
     声明为final, 不可被继承
     String 实现了 Serializable 接口， 表示字符串是支持序列化的
     不可变的字符序列


     实现了comparable 接口， 表示String 可以比较大小

     3. String 内部定义了final char[] value 用于存储字符串数据
     4. String 不可变特性
     4.1 当对字符串重新复制时， 需要重写指定内存区域赋值， 不能使用原有的value进行赋值。
     4.2 当对现有的字符串进行连接操作时， 不能直接赋值，也要重新创建一个；
     4.3 当字符被替换 replace 时，依然新建，原字符串不变
    */


    @Test
    public void test1(){
        String s1 = "abc"; // 字面量, 不用new 不代表不是类， String 也是个类
        String s2 = "abc"; //
        System.out.println(s1 ==  s2); // compare reference address, true
        s1 = "hello";
        System.out.println(s1 ==  s2); // compare reference address, false
        System.out.println(s1); // hello
        System.out.println(s2); // abc

        System.out.println("*********");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3); // abcdef 是新建的
        System.out.println(s2); // abc;

        System.out.println("*********");
        String s4 = "abc";
        String s5= s4.replace("ab", "xy");
        System.out.println(s5); // xyc
        System.out.println(s4); // abc

    }


    /*
    String 的实例化
    方式一： 通过字面量定义
    方式二：  new + 构造器

    面试题： String s = new String("abc"）； 方式创建对象， 在内存中创建了几个对象？
        两个：  一个是堆空间中 new 结构， 另一个是char[] 对应的常量池中的数据： "abc"

     */


    @Test
    public void test2(){
        /* 字面量赋值方法  --> 常量池  same value --> same address */
        // 此时的s1和s2 的数据javaEE 生命在方法区中的常量池中
        String s1= "javaEE";
        String s2 = "javaEE";

        /* 新建对象方法 --> 堆空间中  same value --> diff address */
        String s3 = new String("javaEE"); // new instance, 在堆空间中
        String s4 = new String("javaEE"); // new instance, 在堆空间中
        System.out.println(s1 == s2); // true
        System.out.println(s2 == s3); // false
        System.out.println(s3 == s4); // false


        System.out.println("***********************");


        Person p1 = new Person("alex", 23);
        Person p2 = new Person("alex", 23);

        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true

        p1.name = "Tom";
        System.out.println(p2.name); // alex

    }


    /*

        结论：
         常量（字面量）和常量（字面量）的拼接在常量池中
         常量和变量的拼接在堆当中 （只要其中一个是变量， 就在堆空间当中）。
         intern() 返回值在常量池中"javaEEhadoop"

     */

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE"+ "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s4 == s6); // false
        System.out.println(s5 == s6); // false
        System.out.println(s4 == s7); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        /* intern() 返回值在常量池中"javaEEhadoop" */
        String s8 = s7.intern();
        System.out.println(s8 == s5); // true
    }
}
