package com.alexpower.java;

import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/*
* length()
* charAt()
* isEmpty()
* toLowerCase()
* toUpperCase()
* trim()
*
* equals
* equalsIngnoreCase()
*
* startsWith()
* endsWith()
*
* indexOf() return the index of first char, or -1 if no result
*
*
*
*
*
*  */

public class StringMethodTest {

    @Test
    public void test1(){
        String s1 = "hellowrold";
        System.out.println(s1.length());

        System.out.println(s1.charAt(9));
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(2));
//        System.out.println(s1.charAt(10)); // error

//        s1 = "";
        System.out.println(s1.isEmpty()); // true

        // tolower & upper case, create new string, does not alter s1,

        String s2 = s1.toUpperCase();
        System.out.println(s2); // HELLOWORLD
        System.out.println(s1); // helloworld

        // trim(), remove the both ends space, used when user insert the username or number
        String s3= "  hel lo wo rld  ";
        String s4 = s3.trim();
        System.out.println("---" + s3 + "----");
        System.out.println("---" + s4 + "----");

        // equals just used for comparing the content, not the reference.
        // equalsIgnoreCase() , ignore the case

    }

    @Test
    public void test2(){
        String s1 = "HelloWrold";
        String s2 = "hellowrold";
        System.out.println(s1.equals(s2)); // false
        System.out.println(s1.equalsIgnoreCase(s2)); // true

        // concat()
        String s3 = "today is ";
        String s4 = s3.concat("an amazing day!");

        System.out.println(s4);

        // compareTo()

        String s5 = "abc";

        String s6= "abe";

        String s7 = "zbe";

        System.out.println(s5.compareTo(s6)); // -2
        System.out.println(s5.compareTo(s7));

        // subString(beginIndex, (endIndex));
        String s8 = "中国陕西西安";
        String s9 = s8.substring(2); // begin index : 陕西西安
        System.out.println("---s8: " + s8+ "---s9: " + s9);
        s9 = s8.substring(4,6); // begin index, end index
        System.out.println(s9);
    }


    @Test
    public void test3(){
        String s1 = "helloworld";
        System.out.println(s1.endsWith("d")); // true
        System.out.println(s1.startsWith("He")); // true
        System.out.println(s1.startsWith("ll",2)); // true, startfrom index 2 is "ll"

        String str2 = "wo";
        System.out.println(s1.contains(str2)); // true

        System.out.println(s1.indexOf("lo")); // 3, index of the first char,

        // returns -1 if no result
        System.out.println(s1.indexOf("lo", 5)); // -1

        String str3 = "hellorworld";

        System.out.println(str3.lastIndexOf("or"));  // 7, the last "or"
        System.out.println(str3.lastIndexOf("or", 6)); // 4, the first "or"


    }

    @Test
    public void test4(){
        // String && int
        String str = "23";
        Integer int1 = Integer.parseInt(str);
        System.out.println(int1);

        int x = 100;
        String str2 = String.valueOf(x);
        System.out.println(str2);

    }

    @Test
    public void test5(){

        // String && char[]

        String str1= "abcqwe";

        char[] charArray = str1.toCharArray();
        for(int x= 0; x < charArray.length; x++){
            System.out.println(charArray[x]);
        }

        char[] charArray2 = new char[]{'1', '2','3'};
        String str2 = new String(charArray2);
        System.out.println(str2);

        // challenge: make "abc123" to "a21cb3"
        System.out.println("*******************");

        String str3 = "abc123";
//        char[] newCharArr = str3.toCharArray();
//        System.out.println(newCharArr);
//
//        System.out.println(str3.startsWith("b", 3));
        System.out.println(str3.replace("bc12", "12cb"));
        char[] newchar= new char[]{'1','2','3'};

//        Collection.reverse(Arrays.asList(newchar));


    }

    @Test
    public void test6() throws UnsupportedEncodingException {
        // String and byte

        // 编码： 字符串--> 字节（二进制） （看得懂-》 看不懂的二进制）
        // 解码： 编码的逆过程： 字节 --> 字符串

        // 编码
        String str1 = "ABC中国";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes)); // [65,66,67]

//        byte[] bytes1 = str1.getBytes();
//        String s = new String(bytes1);

        // 解码
        System.out.println(new String(bytes));

        // gbk（编码系统） 编码 && 解码
        byte[] gbks = str1.getBytes("gbk");

        System.out.println(new String(gbks)); // 乱码

        // 在解码时， 解码集必须与编码集一致， 否则会出现乱码

        System.out.println(new String(gbks, "gbk")); // 解码正确
    }

    @Test
    public void test7() {
        String str = "1234567";
        System.out.println(str.matches("\\d+")); // true

        // tell if it's phone from Toronto, Canada

        String phoneNum = "647-5507980";
        System.out.println(phoneNum.matches("(647)-\\d{7,8}")); // true

    }
}
