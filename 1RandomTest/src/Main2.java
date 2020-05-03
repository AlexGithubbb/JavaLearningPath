/* 所有静态初始化器都按文本出现的顺序执行，并在任何实例初始化器之前执行。 */
public class Main2 {
    private static int num;
    {// An instance initializer
        System.out.println("Inside instance initializer.");
    }
    // A static initializer. Note the use of the keyword static below.
    static {
        num = 2014;
        System.out.println("Inside static initializer.");
    }

    // Constructor
    public Main2() {
        System.out.println("Inside constructor.");
    }

    public static void main(String[] args) {
        System.out.println("Inside  main() #1.   num: " + num);
        // Declare a reference variable of the class
        Main2 si;
        System.out.println("Inside  main() #2.   num: " + num);
        new Main2();    // Create an object

        System.out.println("Inside  main() #3.   num: " + num);
        new Main2();// Create another object
    }
}