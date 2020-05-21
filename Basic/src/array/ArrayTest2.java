package array;

import org.junit.Test;

import java.util.Random;

public class AlgorithmTest {
    /* question 1:
     create an array with length of 6, pick random value from 1 to 30, no repeated numbers are allowed
       */
    //       int random2 = (int)Math.random() * (99 - 10 + 1) + 10;
    @Test
    public void test1(){
        int[] arr = new int[6];

        // generate random value from 1 - 30
        int min = 1;
        int max = 30;
        Random random = new Random();
        int[] rans = new int[30];
        for (int i = 0; i < rans.length; i++) {
            int ran = random.nextInt(max - min + 1) + min;
            rans[i] = ran;
            System.out.print(rans[i] + " ");
        }




//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = ran;
//        }
    }


    @Test
    public void test2(){

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int random = (int)(Math.random() * (99 - 10 + 1) + 10);
            arr[i] = random;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // get max value
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("max value: " + max);

        // get min value
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("min value: " + min);
        // get sum

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("total sum: " + sum);
    }

    // copy arr1 from arr
    /*
    * int[] arr = new int[]{1,2,3,...}
    * int[] arr1 = new int[arr.length]
    *
    * for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
    * */

    // this is  not copy, they still point to the same arr
    // arr1 = arr;


    /* reverse the array */

    @Test
    public void reverseTest(){
        String[] names = new String[]{"AA", "BB", "CC"};
        // method 1
//        for (int i = 0; i < names.length/2; i++) {
//            String temp = names[i];
//            names[i] = names[names.length -1 -i];
//            names[names.length -1 -i] = temp;
//        }

        // method 2
                for (int i = 0, j = names.length - 1; i < j; i++, j--) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        // method 3 (the worst)
//        String[] names = new String[]{"AA", "BB", "CC"};
//        String[] names2 = new String[names.length];;
//        for (int i = 0; i < names.length; i++) {
//            // reverse
//            names2[i] = names[names.length -1 -i];
//        }
//
//        for (int i = 0; i < names2.length; i++) {
//            System.out.println(names2[i]);
//        }

    }
}
