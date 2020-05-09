package jdbc.connection;

import jdbc.bean.Order;
import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

public class OrderForQuery {

    @Test
    public void test2(){
        // set alias in sql to match the filed name in Order class;
        String sql = "select order_id orderID, order_name orderName, order_date orderDate from `order` where order_id = ?";
        Order order = getOrder(sql, 4);
        System.out.println(order);
    }


    public Order getOrder(String sql, Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            ps = connection.prepareStatement(sql);

            // set 占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            resultSet = ps.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            while(resultSet.next()){

                Order order = new Order();

                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = resultSet.getObject(i + 1);
                    /* 有时候列名和对象里的属性名不一致，推荐用 getColumnLabel 而不是 getColumnName */
//                  String columnName = metaData.getColumnName(i + 1);

                    String columnLabel = metaData.getColumnLabel(i + 1);
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order, columnValue);
                }

                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, resultSet);
        }
        return null;
    }

    @Test
    public void test() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
             connection = JDBCUtils.getConnection();

            String sql = "select order_id, order_name, order_date from `order` where order_id = ?";
             ps = connection.prepareStatement(sql);
            ps.setObject(1,1);

             resultSet = ps.executeQuery();

            if(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Date date = resultSet.getDate(3);

                Order order = new Order(id, name, date);

                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, resultSet);
        }
    }
}
