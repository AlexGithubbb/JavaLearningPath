package datetime.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {

    /* toString()
    *  getTime()
    * SimpleDateFormat() : format(), parse()
    * Calender
    *
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
    @Test
    public void SimpleDateFormatTest() throws ParseException {
        Date date = new Date();
        System.out.println("Date date: " + date);
        // format current date with default constructor;
        SimpleDateFormat sdf = new SimpleDateFormat();
        String format1 = sdf.format(date);
        System.out.println("default String date after format: "+ format1); // default date format string

        // parse process
        String str1 = "26/04/20 10:15 AM";
        Date date1 = sdf.parse(str1);
//        System.out.println("Date date1 after parse: " + date1);
        System.out.println("Date date1 after parse: " + format1);

        // use different formats to format date
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format2 = sdf1.format(date);
        System.out.println("String date2 after format: " + format2); //2020/04/26 10:29:45

        Date date2 = sdf1.parse(format2);
        System.out.println("Date date2 after parse: " + date2);

    }

    @Test
    public void ConvertToSqlDateTest() throws ParseException {
        String birthD = "1993-05-14";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = sdf.parse(birthD); // use formatConstructor to parse the String and return a new Date date
//        System.out.println(parse);
//        long time = parse.getTime(); // get long type time
//        System.out.println(time); // 737352000000
//        java.sql.Date date1 = new java.sql.Date(time);
//        System.out.println(date1);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.parse(birthD);
        java.sql.Date date1 = new java.sql.Date(sdf.parse(birthD).getTime());
        System.out.println(date1);

    }

    @Test
    public void fishingTest() throws ParseException {
        String startD = "1990-03-03";
//        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf1.parse(startD);
        long startTime = startDate.getTime();

        Date currDate = new Date();
        long currTime = currDate.getTime();

        long diff = currTime - startTime;

        System.out.println(diff);

        long days = diff / (1000*60*60*24) + 1;
        System.out.println(days);

        long remainD  = days%5;
        System.out.println(remainD);
    }
}
