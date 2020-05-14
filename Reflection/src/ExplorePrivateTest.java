import java.lang.reflect.Method;

public class ExplorePrivateTest {
    private String privateMsg = "original";

    private void privateMethod(String head, String tail){
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

            privateMethod.invoke(ept, "reflect", 666);
        }
    }

}
