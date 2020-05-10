package connection;

import jdbc.bean.Customer;
import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DruidTest {

    /*  should also test in jdbc_Dao/junit/jdbc_DAO/CustomerDAOImplTest, the select operation (get single instance or all)  */
    @Test
    public void test() throws Exception {
        Connection connection3 = null;
        PreparedStatement ps = null;
        try {
            connection3 = JDBCUtils.getConnection3();
            String sql = "select id, name, email, birth from customers where id = ?";
            ps = connection3.prepareStatement(sql);

            // fill the `?`
            ps.setString(1,"13");

            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date date = resultSet.getDate(4);

                Customer customer = new Customer(id, name, email, date);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource3(connection3, ps);
        }

    }


}
