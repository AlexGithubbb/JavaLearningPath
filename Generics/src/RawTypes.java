public class RawTypes {
    public static void main(String[] args) {
        /*A raw type is the name of a generic class or interface without any type arguments.
        For example, given the generic Box class: */

        /*To create a parameterized type of Box<T>,
        you supply an actual type argument for the formal type parameter T:
        */
        Box<Integer> stringBox = new Box<>();

        Box rawBox = stringBox;

        rawBox.setT(3);
        System.out.println(rawBox.getT());

        // should avoid using rawType

    }

    public static class Box<T> {
        private T t;
        public void setT(T t){
            this.t = t;
        }

        public T getT() {
            return t;
        }
    }




}
