package random.java;

public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.regist(-1001);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class Student{
    private int id;
//    public void regist(int id) throws Exception{
//        if(id > 0){
//            this.id = id;
//        }else{
////            System.out.println("您输入的数据非法!");
//
//            /*手动抛出异常*/
//            throw new Exception("您输入的数据非法!");
//        }
//    }

    public void regist(int id){
        if(id > 0){
            this.id = id;
        }else{
//            System.out.println("您输入的数据非法!");

            /*手动抛出异常*/
            throw new MyException("禁止输入负数!");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}