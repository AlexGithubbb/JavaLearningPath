package com.alexpower.exer;

import org.junit.Test;

public class StringAlgoTest {
    /* make abc123 change to a21cb3 */
    @Test
    public void test(){
        String str = "abc123";
//        char[] chars = new char[];
        char[] chars =  str.toCharArray();
        String subStr = "";
        for (int i = 1; i < chars.length-1; i++) {
            subStr += chars[chars.length-i-1];
        }
        System.out.println(subStr);
        String newStr = str.substring(0,1).concat(subStr).concat(str.substring(str.length()-1));
        System.out.println(newStr);
    }
//
//    /* imitate trim() */
//    public String trimFromStart(String str){
////        String firsHalf = str;
////        str.indexOf()
//
//
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//
//        }
//    }



}
