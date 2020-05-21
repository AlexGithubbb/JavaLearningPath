package array;

public class PhoneNumberTest {

    /* 18709243135*/
    public static void main(String[] args) {

        int[] nums = new int[]{7, 8, 5,4,3,2,1,0, 9};

        int[] pick = new int[]{6,1,0,7,8, 5,3,4,6,4,2};
        String tel = "";

        for (int i = 0; i < pick.length; i++) {
            tel += nums[pick[i]];
        }
        System.out.print("tel: " + tel);
    }


}
