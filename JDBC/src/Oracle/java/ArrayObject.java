package Oracle.java;

import jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ArrayObject {
    @Test
    public void test() throws Exception {
//        Properties props = new Properties();
//
//        props.load(new FileInputStream(new File("../druid.properties")));


//        String url = props.getProperty("url");

        String sql = " create table REGIONS (REGION_NAME varchar(32) NOT NULL," +
                " ZIPS varchar(32) NOT NULL, PRIMARY KEY (REGION_NAME));" +
                "insert into REGIONS values('Northwest','{\"93101\", \"97201\", \"99210\"}');" +
                "insert into REGIONS values( 'Southwest', '{\"94105\", \"90049\", \"92027\"}')";

        Connection con = JDBCUtils.getConnection3();


//        Connection con = DriverManager.getConnection(url, props);
        PreparedStatement pr = con.prepareStatement(sql);
        pr.execute();

        String [] northEastRegion = { "10022", "02110", "07399" };
        Array aArray = con.createArrayOf("VARCHAR", northEastRegion);

        System.out.println(aArray);
    }


}
