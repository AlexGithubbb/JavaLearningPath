package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class ArrayTest2 {
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
    public void maxMinSumTest2(){

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
        /* for (int i = 0; i < names.length/2; i++) {
            String temp = names[i];
            names[i] = names[names.length -1 -i];
            names[names.length -1 -i] = temp;
        }*/

        // method 2
        for (int i = 0, j = names.length - 1; i < j; i++, j--) {
            String temp = names[i];
            names[i] = names[j];
            names[j] = temp;
        }

        System.out.println(Arrays.toString(names));

        // method 3 (the worst)
/*        String[] names = new String[]{"AA", "BB", "CC"};
        String[] names2 = new String[names.length];;
        for (int i = 0; i < names.length; i++) {
            // reverse
            names2[i] = names[names.length -1 -i];
        }

        for (int i = 0; i < names2.length; i++) {
            System.out.println(names2[i]);
        }*/
    }

    @Test
    public void searchTest(){
        String[] names = new String[]{"AA", "BB", "CC"};
        Boolean isFlag = false;
        String dest = "BB";
        dest = "CC";
        // method 1: linear search
        /*for (int i = 0; i < names.length; i++) {
            if(dest.equals(names[i])){
                System.out.println("we found BB in names, position is : " + i);
                isflag = true;
            }
        }

        if(!isflag){
            System.out.println("sorry, no result");
        }*/


        // method2: binary search (array should be sorted in order (doesn't matter desc or asc), much more effiecit than the linear)
    /*    int[] arr = new int[]{-90, -19, -9, 0, 20, 45,74,100, 333};
        int head = 0;
        int end = arr.length -1;
        int dest1 = 333;
        dest1 = 10;
        Boolean isFlag1 = true;
        while(head <= end){
            int middle = (int)(head + end) / 2;
            if (dest1 == arr[middle]){
                System.out.println("the dest is at position: " + middle);
                isFlag1 = false;
                break;
            }else if(dest1 > arr[middle]){
                head = middle + 1;
            }else if(dest1 < arr[middle]){
                end = middle -1;
            }
        }
        if(isFlag1){
            System.out.println("sorry, no result found");
        }*/


        int[] arr2 = new int[]{-90, -19, -9, 0, 20, 45,74,100, 333};
        int dest2 = 21;
        int index = Arrays.binarySearch(arr2, dest2);
        if(index >= 0){
            System.out.println("the dest is at position: " + index);
        }else{
            System.out.println("sorry, no result found");
        }

    }

    @Test
    public void sortTest(){

        int[] arr = new int[]{-90, 19, -9, 40, 20,74, -87, 100, 333, 250};

        // method 1 bubble sorting
       /* for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }*/

        // method 2 : quick sorting (better, more efficient)
        // .......
        Arrays.sort(arr); // source code of sort() is using quick sort actually.
        System.out.println(Arrays.toString(arr));

    }


}
