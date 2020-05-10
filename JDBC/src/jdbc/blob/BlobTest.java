package jdbc.blob;

// use preparedStatement handle blob data

import jdbc.bean.Customer;
import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class BlobTest {
    // loop up for certain people and download photo (blob data)
    @Test
    public void test2() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select id, name, email, birth, photo from customers where id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,22);

            resultSet = ps.executeQuery();

            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");

                Customer customer = new Customer(id, name, email, birth);

                System.out.println(customer);


                Blob photo = resultSet.getBlob("photo");
                is = photo.getBinaryStream();

                fos = new FileOutputStream(new File("lib/jerry.jpg"));
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer))!= -1){
                    fos.write(buffer,0,len);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // closes the resource
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is!=null)
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JDBCUtils.closeResource(connection, ps, resultSet);
        }




    }

    // insert blob type photo into the db
    @Test
    public void test() throws Exception {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into customers (name, email, birth, photo) values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, "Jerry");
        ps.setObject(2, "jerry123@sina.com");
        ps.setObject(3, "1992-01-01");
        FileInputStream is = new FileInputStream(new File("lib/test.jpg"));
        ps.setBlob(4,is);

        ps.execute();

        JDBCUtils.closeResource(connection, ps);
    }
}
