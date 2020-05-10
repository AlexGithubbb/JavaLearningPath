package jdbc.exer;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertTest {

    /* 优化三：使用 conn.setAutoCommit(false)提高效率 */
    @Test
    public void test4() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            String sql = "insert into goods (name) values(?)";
            ps = connection.prepareStatement(sql);

            // do not allow to submit the data
            connection.setAutoCommit(false);

            for (int i = 1; i <=1000000; i++) {
                ps.setObject(1, "name_" + i );

                ps.addBatch();

                if(i %500 == 0){

                    ps.executeBatch();

                    ps.clearBatch();
                }
            }

            // submit data in the end
            connection.commit();

            long end = System.currentTimeMillis(); // 2092 ms
            System.out.println(end - start);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }

    }
    /* 优化二：addBatch() 进行缓存， executeBatch() & clearBatch() 一定时间节点后进行执行，批量提交数据 */
    @Test
    public void test3() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            String sql = "insert into goods (name) values(?)";
            ps = connection.prepareStatement(sql);

            for (int i = 1; i <= 20000; i++) {
                ps.setObject(1, "name_" + i );

                ps.addBatch();

                if(i %500 == 0){

                    ps.executeBatch();

                    ps.clearBatch();
                }
            }

            long end = System.currentTimeMillis(); // 2092 ms
            System.out.println(end - start);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }

    }

    /* 优化一：使用preparedStatement 批量提交数据, 而不是 statement */
    @Test
    public void test2() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            String sql = "insert into goods (name) values(?)";
            ps = connection.prepareStatement(sql);

            for (int i = 1; i < 20000; i++) {
                ps.setObject(1, "name_" + i );
                ps.execute();
            }

            long end = System.currentTimeMillis(); // 19283 ms
            System.out.println(end - start);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps);
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert your name");
        String name = scanner.next();
        System.out.println("insert your email");

        String email = scanner.next();
        System.out.println("insert your birthday");

        String birth = scanner.next();
        String sql = "insert into customers (name, email, birth) values(?,?,?)";
        int insertCol = update(sql, name, email, birth);

        if(insertCol > 0){
            System.out.println("操作成功！");
        }else{
            System.out.println("操作失败。。。");
        }

    }


    public static int update(String sql, Object ...args) {
        Connection conn = null;
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
            JDBCUtils.closeResource(conn, ps);
        }

        return 0;
    }
}

