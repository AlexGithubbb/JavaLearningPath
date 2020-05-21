package OOP.OOP1;


class PersonTest{
    public static void main(String[] args) {
        // call the detail through field or method
        Person p1 =  new Person();
        p1.name = "Bob";
        p1.setAge(23);
        System.out.println(p1.getName() + "is " +  p1.age +" years old");
    }

}


public class Person {
    // fields
    String name;
    int age;
    Boolean isMale;
    // methods


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

    public Boolean getMale() {
        return isMale;
    }

}
