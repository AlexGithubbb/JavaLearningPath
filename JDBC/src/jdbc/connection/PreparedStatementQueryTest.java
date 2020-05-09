package jdbc.connection;

import jdbc.bean.Customer;
import jdbc.bean.Order;
import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementQueryTest {
    @Test
    public void test3(){
        // set alias in sql to match the filed name in Order class;
        String sql = "select order_id orderID, order_name orderName, order_date orderDate from `order`";
        List<Order> orders = getForList(Order.class, sql);
        orders.forEach(System.out::println);

        System.out.println("\n");

        String sql2 = "select id, name name123, email, birth birthD from customers where id < ?";
        List<Customer> customers = getForList(Customer.class, sql2, 10);
        customers.forEach(System.out::println);
    }


    public <T> List<T> getForList(Class<T> clazz, String sql, Object ...args){
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

            ArrayList<T> ts = new ArrayList<>();
            while(resultSet.next()){
                T t = clazz.newInstance();
                // handle each col of each row of resultSet
                for (int i = 0; i < columnCount; i++) {
                    // Retrieves the value of the designated column in the current row of this ResultSet object
                    Object columnValue = resultSet.getObject(i + 1);

                    // insert the value into Customer by using reflection
                    String columnLabel = metaData.getColumnLabel(i+1);
                    /* 给 t 对象指定的属性赋值 columnValue， 使用reflection*/
                    Field field = clazz.getDeclaredField(columnLabel); // get the field name which is as same as columnLabel;
                    field.setAccessible(true); // 可以访问私有化属性
                    field.set(t, columnValue); // set columnValue to the field
                }

                ts.add(t);

            }

            return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }
        return null;
    }

    @Test
    public void test2(){
        // set alias in sql to match the filed name in Order class;
        String sql = "select order_id orderID, order_name orderName, order_date orderDate from `order` where order_id = ?";
        Order order = getInstance(Order.class, sql, 1);
        System.out.println(order);
    }


    /* 针对不同表的通用查询操作， 返回表中的一条记录*/
    public <T> T getInstance(Class<T> clazz, String sql, Object ...args) {
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
                T t = clazz.newInstance();
                // handle each col of each row of resultSet
                for (int i = 0; i < columnCount; i++) {
                    // Retrieves the value of the designated column in the current row of this ResultSet object
                    Object columnValue = resultSet.getObject(i + 1);

                    // insert the value into Customer by using reflection
                    String columnLabel = metaData.getColumnLabel(i+1);
                    /* 给 t 对象指定的属性赋值 columnValue， 使用reflection*/
                    Field field = clazz.getDeclaredField(columnLabel); // get the field name which is as same as columnLabel;
                    field.setAccessible(true); // 可以访问私有化属性
                    field.set(t, columnValue); // set columnValue to the field
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, resultSet);
        }

        return null;
    }
}
