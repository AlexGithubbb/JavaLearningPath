package datetime.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class JDK8DateTimeTest {
    /* LocalDateTime 相较于 LocalTime and LocalDate 使用的更多*/
    @Test
    public void test(){
        // now() --> get the current date, time, date + time
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);

        // of() --> set the time and date
        LocalDateTime localDateTime = LocalDateTime.of(2022, 12, 13, 15, 23, 54);
        System.out.println(localDateTime);

        // getXxx() 获取相关的属性
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getMonth());
        System.out.println(localDateTime1.getMonthValue());

        // withXxx() 设置相关的属性
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(15);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        // plus() 不可变性， 返回新值
        LocalDateTime localDateTime3 = LocalDateTime.now();
        LocalDateTime localDateTime4 = localDateTime3.plusMonths(8);
        System.out.println(localDateTime4);
        System.out.println(localDateTime4.getMonth());

        // minus() 不可变性， 返回新值
        LocalDateTime localDateTime5 = localDateTime3.minusDays(6);
        System.out.println(localDateTime5);

    }

    /* Instant 时间戳， 类似于 java.util.Date */
    @Test
    public void test2(){
        Instant instant = Instant.now();
        System.out.println(instant);
        // time offset
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(-4)); // 2020-04-26T21:36:37.205Z
        System.out.println(offsetDateTime); // 2020-04-26T17:36:37.205-04:00

        // get Long miliseconds
        System.out.println(instant.toEpochMilli()); // 1587937154328

        // get Instant instance
        Instant instant1 = Instant.ofEpochMilli(instant.toEpochMilli());
        System.out.println(instant1); //
    }

    @Test
    public void test3(){

        // default ISO_LOCAL_DATE_TIME

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTimeStr = dateTimeFormatter1.format(localDateTime);
        System.out.println(localDateTime); // LocalDateTime
        System.out.println(dateTimeStr); // String


        // FormatStyle.SHORT; FormatStyle.MEDIUM; FormatStyle.LONG;

        DateTimeFormatter dateTimeFormatter2 = dateTimeFormatter1.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter3 = dateTimeFormatter1.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter4 = dateTimeFormatter1.ofLocalizedDateTime(FormatStyle.LONG);
        String dateTimeStr2 = dateTimeFormatter2.format(localDateTime);
        String dateTimeStr3 = dateTimeFormatter3.format(localDateTime);
//        String dateTimeStr4 = dateTimeFormatter4.format(localDateTime);
        System.out.println("short: " + dateTimeStr2);
        System.out.println("medium: " + dateTimeStr3);
//        System.out.println("long: " + dateTimeStr4);


        // customized format using ofPattern()
        String str = "2020/04/03 03:33:33";
        LocalDateTime now = localDateTime.now();

        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = dateTimeFormatter.format(localDateTime.now());
        System.out.println(format);

        TemporalAccessor accessor = dateTimeFormatter.parse(str);
        System.out.println(accessor);

    }
}
