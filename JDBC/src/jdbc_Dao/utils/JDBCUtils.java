package jdbc_Dao.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    // get the db connection
    public  static Connection getConnection() throws Exception {
        // get 4 basic information, 获得系统类加载器
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties props = new Properties();

        props.load(is);

        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String driverClass = props.getProperty("driverClass");

        // load driver
        Class.forName(driverClass);

        // get the connection
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    public static void closeResource(Connection conn, PreparedStatement ps){

        try {
            if(ps!= null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(ps!= null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
