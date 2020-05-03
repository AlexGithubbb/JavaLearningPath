public class Main {
    {
        System.out.println("Inside instance initializer 1.");
    }

    {
        System.out.println("Inside instance initializer 2.");
    }

    public Main() {
        System.out.println("Inside  no-args constructor.");
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.getClass()); // class Main

        String str1 = "Alex";
        String str2 = "Alex";
        System.out.println((str1.hashCode() == str2.hashCode())); // true
    }


}