package annotation.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class AnnotationTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.walk();

        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list = new ArrayList();

    }


    @Test
    public void getAnnotation(){
        Class<Student> clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length ; i++) {
            System.out.println(annotations[i]); // @annotation.java.MyAnnotation(value=Hi)
        }
    }
}

@MyAnnotation(value = "Hi")
class Person{
    private String name;
    private int age;

    @MyAnnotation
    public Person() {
    }

    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    public void walk(){
        System.out.println("person is walking");
    }
    @MyAnnotation
    public void sleep(){
        System.out.println("person is sleeping");
    }
}


class Student extends  Person{
    @Override
    public void walk() {
        System.out.println("student is walking");
    }

    @Override
    public void sleep() {
        System.out.println("student is sleeping");
    }
}


