public class GenericMethods {

    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Hello", 22);
        Pair<String, Integer> p2 = new Pair<>("Hello2", 11);


        // method 1 to call compare()
        System.out.println(GenericMethods.compare(p1, p2)); // false
        // method 2 to call compare()
//        boolean same = GenericMethods.<String, Integer>compare(p1, p2);

        /*
        * his feature, known as type inference, allows you to invoke a generic method as an ordinary method,
        *  without specifying a type between angle brackets.
        * This topic is further discussed in the following section, Type Inference.*/
        boolean same = GenericMethods.compare(p1, p2); // simplified syntax
        System.out.println(same);

        p1.setKey("Hello2");
        p2.setValue(22);

        System.out.println(compare(p1, p2)); // true
    }
    // create a generic method
    public static<K, V> boolean compare(Pair<K, V>p1, Pair<K, V>p2){

        return (p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue())
                );
    }

    public static class Pair<K, V>{
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
