package array;

import org.junit.Test;

/*
>. once the size of array settled, can't change it any more
>. dimensions: 1 ,2



 */
public class ArrayTest {
    public static void main(String[] args) {

        // static initialization with items assigned
        String[] names =  new String[]{"A", "B", "ccc"};

        // dynamic initialization, will assign item later
        int[] ids = new int[3];

        // call item
        System.out.println(names[1]);

        ids[0] = 1;
        ids[1] = 3;
        ids[2] = 2;

        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] + " ");
        }

    }

    @Test
    public void pointerTest(){
        int[] nums = new int[5];
        // the address where nums is pointing at

        System.out.println(nums); // [I@deb6432

        System.out.println(nums[0]); // 0
        nums[1] = 1;
        System.out.println(nums[1]);
    }
}
