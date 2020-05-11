package connection.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class C3P0Test {
    @Test
    public void test() throws Exception {
        // get C3P0 datasourcePool
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&rewriteBatchedStatements=true&useServerPrepStmts=false" );
        cpds.setUser("root");
        cpds.setPassword("Oracle3*+");

        // set initial pool size is 10 connections
        cpds.setInitialPoolSize(10);

        Connection connection = cpds.getConnection();
        System.out.println(connection);

        // destroy c3p0 datasource pool
//        DataSources.destroy(cpds);
    }


    // leverage config file
    @Test
    public void test2() throws Exception {
        // get data source pool by looking for the pool name (in config.xml)
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");

        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

    public static class JDBCUtils {



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
}
