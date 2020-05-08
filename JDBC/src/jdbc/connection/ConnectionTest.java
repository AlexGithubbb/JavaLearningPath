package jdbc.connection;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    @Test
    public void test3() throws Exception {

        // using reflection to get the instance
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");

        // get driver
        Driver driver = (Driver) clazz.newInstance();

        // create url, user and paswd
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password  = "Oracle3*+";

        // register driver
        DriverManager.registerDriver(driver);

        // get connection,we need url, user, password
        Connection conn =  DriverManager.getConnection(url, user, password);

        System.out.println(conn);
    }

    /* method2: reflection, 对method1的迭代， 具有更好的 可移植性？ */
    @Test
    public void test2() throws Exception {
            // 1.获取Driver实现类的对象
            Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");

            Driver driver = (Driver) clazz.newInstance();

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Properties info = new Properties();

            info.setProperty("user", "root");
            info.setProperty("password", "Oracle3*+");

        Connection conn = driver.connect(url, info);
        System.out.println(conn);
        }

    /* method1 */
    @Test
    public void test() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "Oracle3*+");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }
}
