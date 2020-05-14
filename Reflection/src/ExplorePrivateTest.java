import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ExplorePrivateTest {
    private String privateMsg = "Original";

    private void privateMethod(String head, int tail){
        System.out.println(head + " " + tail);
    }

    public String getMsg(){
        return privateMsg;
    }

    private void getPrivateMethod() throws Exception{
        ExplorePrivateTest ept = new ExplorePrivateTest();
        Class clazz = ept.getClass();

        Method privateMethod = clazz.getDeclaredMethod("privateMethod", String.class, int.class);

        if(privateMethod != null){
            privateMethod.setAccessible(true);

            privateMethod.invoke(ept, "java reflect", 666);
        }
    }

    @Test
    public void test() throws Exception {
        getPrivateMethod();
    }

    private void modifyPrivateField() throws NoSuchFieldException, IllegalAccessException {
        ExplorePrivateTest ept = new ExplorePrivateTest();
        Class clazz = ept.getClass();

        Field privateField = clazz.getDeclaredField("privateMsg");

        if(privateField != null){

            privateField.setAccessible(true);
            System.out.println("Before modified: " + ept.getMsg());

            privateField.set(ept, "Modified");

            System.out.println("After modified: " + ept.getMsg());
        }
    }

    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        modifyPrivateField();
    }

}
