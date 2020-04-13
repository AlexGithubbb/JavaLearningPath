package java2;

import org.junit.Test;

import java.util.List;

public class Inheritence {

    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj= str;

        Object[] arr = null;
        String[] arr2 = null;
        arr = arr2;

        /*虽然 String 是 Object 的子类， 但是 G<String> 和 G<Object> 不是子父类关系*/
        List<Object> list1 = null;
        List<String> list2 = null;

//        list1 = list2; // error : Incompatible types, list1 和 list2 不具有子父类关系


    }
}
