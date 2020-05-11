package apacheDBUtils;

import jdbc.bean.Customer;
import jdbc.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/* 封装数据库的增删改查操作*/
public class QueryRunnerTest {
    @Test
    public void getMaxBirthTest() throws Exception {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();

            connection = JDBCUtils.getConnection3();
            String sql = "select max(birth) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();

            Date date = (Date) queryRunner.query(connection, sql, scalarHandler);

            // get the youngest birth day
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }

    }

    @Test
    public void getCountTest() throws Exception {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();

            connection = JDBCUtils.getConnection3();
            String sql = "select count(*) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();

            Object count = queryRunner.query(connection, sql, scalarHandler);

            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }

    }

    @Test
    public void queryTest() throws Exception {
        Connection connection = JDBCUtils.getConnection3();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id, name, email, birth from customers where id = ?";

        BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
        Customer customer = queryRunner.query(connection, sql, handler, 2);
        System.out.println(customer);
    }

    @Test
    public void queryTest2() throws Exception {
        Connection connection = JDBCUtils.getConnection3();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id, name, email, birth from customers where id > ?";

        BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
        List<Customer> list = queryRunner.query(connection, sql, handler, 10);
        list.forEach(System.out::println);
    }



    @Test
    public void insertTest() throws Exception {
        Connection connection = null;
        try {
            QueryRunner queryRunner = new QueryRunner();

            connection = JDBCUtils.getConnection3();

            String sql = "insert into customers (name, email, birth) values(?, ? ,?)";
            int dataCount = queryRunner.update(connection, sql, "WuKong", "monkey1@yahoo.com", "1900-01-01");

            System.out.println("添加了 " + dataCount  + " 条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }


    }

}
