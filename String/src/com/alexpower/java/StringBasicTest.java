package com.alexpower.java;

public class StringBasicTest {

    String str = new String("good"); // String 的不可变性
    char[] ch = {'t','e','s', 't'}; // array 是可变的

    public void change(String str, char ch[]){
        str = "it works";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringBasicTest st = new StringBasicTest();
        st.change(st.str, st.ch);

        System.out.println(st.str);
        System.out.println(st.ch);
    }
}
