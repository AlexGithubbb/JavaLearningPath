package datetime.java;

import org.junit.Test;

import java.util.Date;

public class DateTimeTest {

    /* toString()
    *  getTime()
    * */
    @Test
    public void test(){
        // empty params constructor tell us the current time information
        Date date1 = new Date();
        System.out.println("空参toString() : " + date1.toString()); // Tue Apr 21 23:01:59 EDT 2020; detailed info

        /* the miliseconds from 1970,1,1 */
        System.out.println("空参getTime() :" + date1.getTime()); // 1587524519973; same to System.currentTimeMillis();

        Date date2 = new Date(1587524519973L);
        System.out.println("带参Date构造器打印值： " + date2);

        /* sql.Date */
        Date date3 = new java.sql.Date(31231421314L);
        System.out.println("数据库提取时间： " + date3);

        /* cast java.util.Date --> java.sql.Date */

        Date d1 = new Date();
        java.sql.Date d2 = new java.sql.Date(d1.getTime());
        System.out.println(d2);
    }
}
