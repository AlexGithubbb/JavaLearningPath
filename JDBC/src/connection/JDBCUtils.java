package connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtils {



    /* leverage C3P0 tech db connection pool */
    // 先造池
    static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    //后获取连接  get connection
    public static Connection getConnection() throws SQLException {
        Connection conn = cpds.getConnection();
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

}
