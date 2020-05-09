package jdbc.connection;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class PreparedStatementUpdateTest {

    public void updateDB(String sql, Object ...args) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            // get connection
            conn = JDBCUtils.getConnection();

            // fill out the ?
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close resource
            JDBCUtils.closeResource(conn, ps);
        }
    }

    @Test
    public void test4() throws Exception {

        String sql = "update `order` set order_name = ? where order_id = ?";
        updateDB(sql, "PP", 2);
    }

    @Test
    public void test3() throws Exception {
        String sql = "update customers set name = ?, email = ? where id = ?";
        updateDB(sql, "Alex", "alex@123.com", 19);

    }



    @Test
    public void test2() throws Exception {


        JDBCUtils jdbcUtils = null;
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = JDBCUtils.getConnection();

            String sql = "update customers set name = ? , email = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "牛顿");
            ps.setObject(2, "newton@sina.com");
            ps.setObject(3, 16);

            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeResource(conn, ps);
        }


    }

    @Test
    public void test() throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;

        try {
            // get 4 basic information
            InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties props = new Properties();

            props.load(is);

            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String driverClass = props.getProperty("driverClass");

            // load driver
            Class.forName(driverClass);

            // get the connection
            conn = DriverManager.getConnection(url, user, password);

            // set up preparedStatement
            String sql = "insert into customers(name, email, birth)values(?, ? ,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, "Bob");
            ps.setString(2, "bobsuper@gmail.com");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse("1999-12-31");

            ps.setDate(3, new java.sql.Date(date.getTime()));

            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // close !!!

            try {
                if(ps!= null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn != null)
                    conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }

        }







    }
}
