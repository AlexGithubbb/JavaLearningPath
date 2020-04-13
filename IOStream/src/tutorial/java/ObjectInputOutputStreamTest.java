package tutorial.java;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {
    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
             oos = new ObjectOutputStream(new FileOutputStream("test.data"));
             /*Serialization 序列化对象， 使其具备持久性 */
            oos.writeObject("Hello world, 我是中国人");
            oos.flush();

            oos.writeObject(new Person("Bob", 23));
            oos.flush();

            oos.writeObject(new Person("Bob", 23, 1001, new Account(1999.23)));
            oos.flush();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("test.data"));
            /* 对象的反序列化， 还原对象到内存中 */
            // write String first, then read it first
            Object object = ois.readObject();
            String str = (String) object;
            Person p1 = (Person) ois.readObject();
            System.out.println(str);
            System.out.println(p1);

            Person p2 = (Person) ois.readObject();
            System.out.println(p2);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
