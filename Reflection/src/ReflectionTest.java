import bean.Son;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/* leverage reflection, we can get information about class and parentClass's fields and methods */

public class ReflectionTest {

    @Test
    public void getFields(){
        Class son = Son.class;
        System.out.println("类的名称： " + son.getName()); //类的名称：  bean.Son

//        Field[] fields = son.getFields(); // get all fields that are public from Son and also Father

        /*
        类的名称： bean.Son
        public class java.lang.String sonBirth
        */

         Field[] fields = son.getDeclaredFields(); // get the fields from Son class (includes private and protected when accessible set to true)

         /*
         * 类的名称： bean.Son
            private class java.lang.String sonName
            protected int sonAge
            public class java.lang.String sonBirth
          */

        for(Field field : fields){
            field.setAccessible(true);
            int modifiers = field.getModifiers();
            String modifierStr = Modifier.toString(modifiers);
            System.out.println(modifierStr + " " + field.getType() + " " + field.getName());
        }
    }


    @Test
    public void getMethods(){
        Class son = Son.class;

//        Method[] methods = son.getMethods(); // get all public methods from Son and Father class

        Method[] methods = son.getDeclaredMethods(); // get all methods from Son class

        for(Method method: methods){

            // get method returning value type and method name
            int modifiers = method.getModifiers();
            String modifierStr = Modifier.toString(modifiers);

            System.out.print(modifierStr + " " + method.getReturnType() + " " + method.getName() + " ( ");


            // get params
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter: parameters){
                System.out.print(parameter.getType() + " " + parameter.getName() + " ,");
            }

            // get exceptions
            Class<?>[] exceptionTypes = method.getExceptionTypes();

            if(exceptionTypes.length > 0){
                for(Class e: exceptionTypes){
                    System.out.println(") throws " + e.getName());
                }
            }else{
                System.out.println(" )");
            }
        }
    }


}
