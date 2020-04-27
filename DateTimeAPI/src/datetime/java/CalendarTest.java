package datetime.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    @Test
    public void test(){
        //实例化
        //方式一： 创建GregorianCalendar的子类对象
        //方式二： 调用静态 getInstance()方法
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); //java.util.GregorianCalendar

        /* get , set , add, getTime, setTime */

        int days = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int months = calendar.get(Calendar.MONTH) + 1;
        System.out.println(days);
        System.out.println(months);
        System.out.println(dayOfYear);


        // set
        calendar.set(Calendar.DAY_OF_MONTH, 01); // void method
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // add
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        // getTime Calendar --> Date
        Date time = calendar.getTime();
        System.out.println(time);

        // setTime : Date --> Calendar
        Date date = new Date();
        calendar.setTime(date);
        int days1 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days1);


    }


}
