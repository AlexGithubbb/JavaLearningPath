public class BoundedTypePrams {
//    https://docs.oracle.com/javase/tutorial/java/generics/bounded.html
    /*
    * To declare a bounded type parameter, list the type parameter's name,
    * followed by the extends keyword, followed by its upper bound,
    * which in this example is Number. Note that, in this context,
    * extends is used in a general sense to mean either "extends"
    * (as in classes) or "implements" (as in interfaces).*/

    public static class Box<T> {

        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }

        public static void main(String[] args) {
            Box<Integer> integerBox = new Box<Integer>();
            integerBox.set(10);
//            integerBox.inspect("hello"); // error: this is still String!
            integerBox.inspect(10.34); // no error: this is a Number type

            NaturalNumber<Integer> naturalNum = new NaturalNumber<>(12);
            System.out.println(naturalNum.isEven());


        }

        public <U extends Number> void inspect(U u){
            System.out.println("T: " + t.getClass().getName()); // java.lang.Integer
            System.out.println("U: " + u.getClass().getName()); // java.lang.Double
        }

        public static class NaturalNumber<T extends Integer> {

            private T n;

            public NaturalNumber(T n)  { this.n = n; }

            public boolean isEven() {
                return n.intValue() % 2 == 0;
            }
        }

        /*
        * Multiple Bounds
        The preceding example illustrates the use of a type parameter with a single bound,
        * but a type parameter can have multiple bounds:

        <T extends B1 & B2 & B3>
        *
        A type variable with multiple bounds is a subtype of all the types listed in the bound.
        * If one of the bounds is a class, it must be specified first. For example:

        Class A {.. }
        interface B { .. }
        interface C { ..}

        class D <T extends A & B & C> { .. }
        If bound A is not specified first, you get a compile-time error:

        class D <T extends B & A & C> { ..}  // compile-time error
        */



      /* Generic Methods and Bounded Type Parameters */


//        public static <T> int countGreaterThan(T[] anArray, T elem) {
//            int count = 0;
//            for (T e : anArray)
//                if (e > elem)  // compiler error
//                    ++count;
//            return count;
//        }

        public static <T extends Comparable<T>> int GreaterThanNUm(T[] anArray, T elem){
            int count = 0;
            for(T e: anArray){
                if(e.compareTo(elem) > 0){ // we need to create an interface
                    count ++;
                }
            }
            return count;
        }

        // now we need to create a compareTo interface
        public interface Comparable<T>{
            int compareTo(T o);
        }



    }
}
