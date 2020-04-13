package com.alexpower.exer;

public class StringTest {

    String str = new String ("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str); // 引用变量会变， 但是 str 特殊，不可变
        System.out.println(ex.ch); // 引用变量数组会变
    }
}
