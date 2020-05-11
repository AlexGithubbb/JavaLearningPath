package jdbc_2.transaction;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/* transaction:
* 1. data will auto submit after connection,
* 2. data will submit when connection got closed.
* */
public class TransactionTest {

    @Test
    public void updateTransactionIsolationTest() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";

//        Thread.sleep(15000);

        update2(connection, sql, "4000", "DD");

        connection.commit();
        connection.close();
    }
    @Test
    public void selectTransactionIsolationTest() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            System.out.println(connection.getTransactionIsolation());

            String sql = "select user, password, balance from user_table where user = ?";

            User user = getInstance(connection,User.class, sql, "DD");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection, null);
        }

    }



    @Test
    public void test() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql1 = "update user_table set balance  = balance +300 where user = ? ";
            // set auto commit to false
            connection.setAutoCommit(false);
            update2(connection,sql1,"AA");

//            System.out.println(10/0);

            String sql2 = "update user_table set balance  = balance - 100 where user = ? ";
            update2(connection, sql2,"BB");

            // submit the data when the whole transaction got executed!
            connection.commit();
        } catch (Exception e) {
            // 在数据库连接池的场景下使用
            connection.setAutoCommit(true);
            e.printStackTrace();
            // rollback whole process if there is an exception occured.
            connection.rollback();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }

    }

    public static  <T> T getInstance(Connection connection, Class<T> clazz, String sql, Object ...args) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {

            ps = connection.prepareStatement(sql);

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
            JDBCUtils.closeResource(null, ps, resultSet);
        }

        return null;
    }



    public static int update2(Connection conn, String sql, Object ...args) {
        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement(sql);

            // 处理占位符 '？'
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }

            // return true if there is a resultSet, means we are doing select command
            // false if update(insert, delete, update)
            /*ps.execute();*/

            // in order to tell if the DML sucess
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, ps);
        }

        return 0;
    }



//    public static int update(String sql, Object ...args) {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            conn = JDBCUtils.getConnection();
//
//            ps = conn.prepareStatement(sql);
//
//            // 处理占位符 '？'
//            for (int i = 0; i < args.length; i++) {
//                ps.setObject(i+1, args[i]);
//            }
//
//            // return true if there is a resultSet, means we are doing select command
//            // false if update(insert, delete, update)
//            /*ps.execute();*/
//
//            // in order to tell if the DML sucess
//            return ps.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            JDBCUtils.closeResource(conn, ps);
//        }
//
//        return 0;
//    }
}
