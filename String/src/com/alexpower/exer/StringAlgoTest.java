package com.alexpower.exer;

import org.junit.Test;

public class StringAlgoTest {
    /* make abc123 change to a21cb3 */

/*    public String reverse1 (String str, int start, int end){
        char[] chars = str.toCharArray();
        String subStr = "";
        for (int i = end; i >= start; i--) {
            subStr += chars[i];
        }
        System.out.println(subStr);
        return  str.charAt(str.indexOf(chars[start-1]))+ subStr + str.charAt(str.indexOf(chars[end+1]));
    }*/

    /* method2 , tring 拼接 */
//    public String reverse2 (String str, int start, int end){
//        String subStr = str.substring(0, start);
//        for (int i = end; i >= start; i--) {
//            subStr += str.charAt(i);
//        }
//    return  subStr + str.substring(end + 1);
//    }

/*
    // method3: StringBuilder/ Buffer, more efficient, use append() and toString()
*/
    public String reverse3(String str, int start, int end){
     if(str != null){
         StringBuilder builder = new StringBuilder(str.length());
         builder.append(str.substring(0, start));
         for (int i = end; i >= start; i--) {
             builder.append(str.charAt(i));
         }

      /*  String reverse = new String(builder);
        return reverse + str.substring(end + 1);*/

         builder.append(str.substring(end + 1));
         return builder.toString();
     }
     return null;
    }

    // method 4, 5, 6 .....

    public static void main(String[] args) {
        StringAlgoTest stringAlgoTest = new StringAlgoTest();
        String result = stringAlgoTest.reverse3("abc123", 1, 4);
        System.out.println(result);
    }

    @Test
    public void test(){
       String str = null;
       StringBuffer  stb = new StringBuffer();
       stb.append(str);
        System.out.println(stb.length()); // 4
        System.out.println(stb); // "null"

//        source code:

//        private AbstractStringBuilder appendNull() {
//            int c = count;
//            ensureCapacityInternal(c + 4);
//            final char[] value = this.value;
//            value[c++] = 'n';
//            value[c++] = 'u';
//            value[c++] = 'l';
//            value[c++] = 'l';
//            count = c; //4
//            return this;
//        }

        StringBuffer sb2 = new StringBuffer(str);
        System.out.println(sb2); // Exception -> NullPointerException



    }

}
