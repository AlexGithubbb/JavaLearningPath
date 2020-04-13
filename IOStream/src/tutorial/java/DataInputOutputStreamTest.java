package tutorial.java;

import org.junit.Test;

import java.io.*;
/*Data streams support binary I/O of primitive data type values
(boolean, char, byte, short, int, long, float, and double) as well as String values.
All data streams implement either the DataInput interface or the DataOutput interface.
This section focuses on the most widely-used implementations of these interfaces,
DataInputStream and DataOutputStream.
*/
public class DataInputOutputStreamTest {
    @Test
    public  void test() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("Alex");
        dos.flush(); // write the data into the file
        dos.writeInt(27);
        dos.flush();
        dos.writeBoolean(true);
    }

    @Test
    public  void test2() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        /*the order of reading diff types of data should be same as the order of writing the variables*/
        String name = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();

        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("isMale: " + isMale);
    }
}
