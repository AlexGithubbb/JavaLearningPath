package jdbc.connection;

import jdbc.bean.Customer;
import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class CustomerForQuery {

    @Test
    public void test4() throws Exception {
        String sql = "select id, name name123, email, birth birthD from customers where id =?";
        Customer customer = getResult(sql, 18);
        System.out.println(customer);

    }

    public Customer getResult(String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);

            // 处理占位符 '？'
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }


            resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();


            if(resultSet.next()){
                Customer cust = new Customer();
                // handle each col of each row of resultSet
                for (int i = 0; i < columnCount; i++) {
                    // Retrieves the value of the designated column in the current row of this ResultSet object
                    Object columnValue = resultSet.getObject(i + 1);

                    // insert the value into Customer by using reflection
                    String columnLabel = metaData.getColumnLabel(i+1);

                    Field field = Customer.class.getDeclaredField(columnLabel); // get the field name which is as same as columnLabel;
                    field.setAccessible(true); // 可以访问私有化属性
                    field.set(cust, columnValue); // set columnValue to the field
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null;
    }

    @Test
    public void test() throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select id, name, email, birth from customers where id = ?";

            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);


            resultSet = ps.executeQuery();

            if(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);
                Customer customer = new Customer(id, name, email, birth);

                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close resource
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
    }
}
