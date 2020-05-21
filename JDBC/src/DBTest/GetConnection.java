package DBTest;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class GetConnection {
    public static Connection getConnection() throws Exception {
        // set driver
        Class<?> clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        InputStream is = clazz.getClassLoader().getResourceAsStream("testDB.properties");

        Properties pro = new Properties();
        pro.load(is);

        String url = pro.getProperty("url");
        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String driverClass = pro.getProperty("DriverClass");

        Connection connection = DriverManager.getConnection(url, user, password);

        // return connection
        return connection;
    }
}
