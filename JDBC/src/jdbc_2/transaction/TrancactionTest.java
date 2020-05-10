package jdbc_2.transaction;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/* transaction:
* 1. data will auto submit after connection,
* 2. data will submit when connection got closed.
* */
public class TrancactionTest {

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
            e.printStackTrace();
            // rollback whole process if there is an exception occured.
            connection.rollback();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }

    }


    public static int update2(Connection conn, String sql, Object ...args) {
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();

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
