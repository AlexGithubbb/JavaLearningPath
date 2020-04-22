package com.alexpower.java;

import org.junit.Test;



/*
*       String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
*StringBuffer: own synchronized methods ---> more secure && lower efficiency;
*StringBuilder: no synchronized method ---> less secure && higher efficiency;
*
*
* StringBuilder && StringBuffer 的底层数组容量默认为16个，如果新建数组的长度大于16， 则会进行扩容，
* 容积变为之前的2倍 + 2；， 同时将原有数组复制到新数组中；
*
* 在实际开发中，建议： 使用 StringBuilder(int capacity) or StringBuffer (int capacity)
*
*
*  ********** methods **********
* append()
* delete( int start, int end)
* replace( int start, int end, String str ) / setCharAt(start index, xx )
* reverse()
* insert( int offset, xxx )
* length()
* StringBuffer.toString()
*
*
*
* */
public class StringBufferBuilderTest {

    @Test
    public void test(){
        StringBuffer sbf = new StringBuffer("CBA");
        sbf.setCharAt(0,'N');
        System.out.println(sbf); // NBA
    }


    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('2');
        System.out.println(s1);
        s1.delete(3,5);
        System.out.println(s1);
        s1.setCharAt(0,'c');
        System.out.println(s1);


        StringBuffer s2 = new StringBuffer("ILoveJava");
        StringBuffer s21 = s2.reverse();
        System.out.println(s21);

        StringBuffer s3 = new StringBuffer("ILoveJava");
        String s4 = s3.substring(5,9);
        System.out.println(s4);

        StringBuffer s5 =  s3.insert(1, "Do");
        System.out.println(s5); // IDoLoveJava

        System.out.println(s5.delete(1, 3)); // ILoveJave
        StringBuffer s6 = s3.replace(5, 9, "Javascript");
        System.out.println(s6);

        StringBuffer s7 = s2.reverse().append("script");
        System.out.println(s7);
    }


    /* compare String, StringBuffer, StringBuilder time cost */
    @Test
    public void test3(){
        String s1 = "";
        StringBuffer s2 = new StringBuffer("");
        StringBuilder s3 = new StringBuilder("");

        Long startTime = 0L;
        Long endTime = 0L;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s1 = s1 + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String costed: " + (endTime - startTime));startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s2.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer costed: " + (endTime - startTime));startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            s3.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder costed: " + (endTime - startTime));

    }
}
