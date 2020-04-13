public class Generics_Inherit_Subtypes {

//    https://docs.oracle.com/javase/tutorial/java/generics/inheritance.html
public static void main(String[] args) {
    Box<Number> box = new Box<>(1.111);

    /*
    * you can assign an Integer to an Object, since Object is one of Integer's supertypes:
    *
    */
    Object someObject = new Object();
    Integer someInteger = new Integer(10);
    someObject = someInteger; // OK


}

    public static class Box<T>{
        private T t;

        public Box(T t) {
            this.t = t;
        }

    }
}
