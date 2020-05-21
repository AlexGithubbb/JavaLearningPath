package jdbc.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    /* method 5: pros:
    * 1. using db.properties config 实现数据和代码的分离， 实现解耦
    * 2. if need to modify config data, using this way can get avoid of 程序重新打包，
    * */
    @Test
    public void getConnectionMethod5() throws IOException, ClassNotFoundException, SQLException {

        // get 4 basic information
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties props = new Properties();

        props.load(is);

        System.out.println(props);

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String driverClass = props.getProperty("driverClass");

        // load driver
        Class.forName(driverClass);

        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println(conn);

    }

    @Test
    public void getConnectionMethod4() throws Exception{

        // get parameters url, user, password

        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "Oracle3*+";


        // reflection to get driver
        Class.forName("com.mysql.cj.jdbc.Driver");

//        Driver driver = (Driver) clazz.newInstance();
        // register driver
//        DriverManager.registerDriver(driver);
        /* in com.mysql.cj.jdbc.Driver, already done the register job for us, so we don't need to DriveManager.RegisterDriver(driver) again*/

        /*    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
        }*/

        // get connection
        Connection connection = DriverManager.getConnection(url, user, password);

        // pirint out connection
        System.out.println(connection);
    }
    @Test
    public void getConnectionMethod3() throws Exception {

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
    public void getConnectionMethod2() throws Exception {
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
    public void getConnectionMethod() throws SQLException {
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
