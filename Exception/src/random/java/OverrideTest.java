package random.java;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverrideTest {

/*
* 1.如果父类中使用throws 没有异常， 那么子类中重写父类方法的那个方法也不能用 throws 处理异常，
* 而是要用 try-catch 来进行处理
*
* 2. 执行的方法a中，先后调用了数个方法， 且这些方法是递进关系， 则在各方法内用 throws 上传异常，再由方法a 进行
* try-catch 处理异常
*
*
*
* */
    public static void main(String[] args) {
        // can not call display() from static method as: OverrideTest.display()
        // need to create a new instance to access  it.
        OverrideTest test = new OverrideTest();
        test.display(new SubClass());
    }

    // non-static method, can not be called from static method as: OverrideTest.display()
    public void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    static class SuperClass{
//        public void method() throws IOException{}
//    }
//    static class SubClass extends SuperClass {
//        // override SuperClass.method()
//        public void method() throws FileNotFoundException{
//        }
//    }
}


 class SuperClass{
    public void method() throws IOException{}
}
 class SubClass extends SuperClass {
    // override SuperClass.method()
    public void method() throws FileNotFoundException{
    }
}

/*
*
* A non-static method belongs to an object of the class and you have to
*   create an instance of the class to access it.*/
