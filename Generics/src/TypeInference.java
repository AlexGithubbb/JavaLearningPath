public class TypeInference {
    public static class BoxDemo {
        public static class Box<T>{
            private T t;

            public void set( T t){
                this.t = t;
            }
            public T get(){
                return t;
            }
        }


        public static <T> void addBox(T t, java.util.List<Box<T>> boxes){
            Box<T> box = new Box<>();
            box.set(t);
            boxes.add(box);
        }

        public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
            int counter = 0;
            for (Box<U> box: boxes) {
                U boxContents = box.get();
                System.out.println("Box #" + counter + " contains [" +
                        boxContents.toString() + "]");
                counter++;
            }
        }

        public static  void main(String[] args) {
            java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
                    new java.util.ArrayList<>();

            BoxDemo.<Integer>addBox(10, listOfIntegerBoxes);
            BoxDemo.addBox(20, listOfIntegerBoxes);
            BoxDemo.addBox(30, listOfIntegerBoxes);
            BoxDemo.outputBoxes(listOfIntegerBoxes);
        }
    }

    /*Type Inference and Generic Constructors of Generic and Non-Generic Classes*/
    class MyClass<X> {
        <T> MyClass(T t) {
        }
    }


    MyClass<Integer> myObject = new MyClass<>("hello");

 /*
    static <T> List<T> emptyList();

    List<T> list = Collections.emptyList();

    void processStringList(List<String> stringList) {
        // process stringList
    }

    processStringList(Collections.emptyList()); // not work in JAVA SE 7

    // has to be like this in SE 7:
    processStringList(Collections.<String>emptyList());
*/

}
