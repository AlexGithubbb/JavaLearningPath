package jdbc_Dao;

import jdbc_Dao.bean.Customer;
import jdbc.utils.JDBCUtils;
//import connection.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public class CustomerDAOImplTest {

    private CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    public void insert() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Customer customer = new Customer(5,"Julie", "julie@gmail.com", new Date(12314214L));
            dao.insert(connection, customer);
            System.out.println("insert success!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }

    }

    @Test
    public void deleteById() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            dao.deleteById(connection, 23);
            System.out.println("delete success!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }

    }

    @Test
    public void update() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Customer customer = new Customer(20, "coco", "coco@gmail.com", new Date(12151245L));
            dao.update(connection, customer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }
    }

    @Test
    public void getCustomerById() throws Exception {
        Connection connection = null;
        try {
//            connection = JDBCUtils.getConnection();
            connection = JDBCUtils.getConnection3();

            Customer customer = dao.getCustomerById(connection, 20);

            System.out.println(customer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }
    }

    @Test
    public void getAll() throws Exception {
        Connection connection = null;
        try {
//            connection = JDBCUtils.getConnection();
            connection = JDBCUtils.getConnection3();

            List<Customer> list = dao.getAll(connection);
            list.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }    }

    @Test
    public void getCount() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            Long count = dao.getCount(connection);

            System.out.println("data sum: " +count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }
    }

    @Test
    public void getMaxBirth() throws Exception {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            Date maxBirth = dao.getMaxBirth(connection);
            System.out.println("max birth: " +maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, null);
        }
    }
}