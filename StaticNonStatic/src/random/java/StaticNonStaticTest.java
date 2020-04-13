package random.java;
/*
* Characteristics of Static methods
A static method is called using the class (className.methodName) as opposed to to an instance reference (new instanceOfClass = class; instanceOfClass.methodName.)
Static methods can’t use non-static instance variables: a static method can’t refer to any instance variables of the class. The static method doesn’t know which instance’s variable value to use.
Static methods can’t call non-static methods: non-static methods usually use instance variable state to affect their behaviour. Static methods can’t see instance variable state, so if you try to
call a non-static method from a static method the compiler will complain regardless if the non-static method uses an instance variable or not.
*
*
Non-Static methods
A non-static method does not have the keyword static before the name of the method.
A non-static method belongs to an object of the class and you have to create an instance of the class to access it.
Non-static methods can access any static method and any static variable without creating an instance of the class.
*
*
*
*
*
*
*
* */
public class StaticNonStaticTest {

    public static void main(String[] args) {
        StaticNonStaticTest test = new StaticNonStaticTest("A", 23);
        test.setName("bob");
        System.out.println(test.getName());
    }


    private String name;
    private int age;

    public StaticNonStaticTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
