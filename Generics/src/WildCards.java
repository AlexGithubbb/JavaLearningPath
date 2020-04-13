import java.util.Iterator;
import java.util.List;

public class WildCards {
    public static void main(String[] args) {
        List<String> list1 = null;
        List<Object> list2 = null;

        // list 1 and list2 are not related, but they both are subclass of List<?>

        List<?> list = null;
        list = list1;
        list = list2;

        print(list1);
        print(list2);
    }

//    @Test
//    public void test() {
//        List<String> list1 = null;
//        List<Object> list2 = null;
//
//        // list 1 and list2 are not related, but they both are subclass of List<?>
//
//        List<?> list = null;
//        list = list1;
//        list = list2;
//
//        print(list1);
//        print(list2);
//    }

    public static void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
