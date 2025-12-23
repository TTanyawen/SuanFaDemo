package basicTool;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/*
原来使用Date和Calendar，缺点：可变，不直观，线程不安全

jdk8引入新的日期和时间API：Local系列
    LocalDate
    LocalTime
    LocalDateTime
    Instant 时间戳
 */
public class LocalData_TimeDemo {
    public static void main(String[] args) {
        LocalDate date=LocalDate.now();
        System.out.println(date);

        LocalTime time=LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(dateTime);

        LocalDate date2=LocalDate.of(2003,10,14);
        LocalDate tmr2=date2.plusDays(1);
        LocalDate lastMonth=date2.minusMonths(1);


        Instant now=Instant.now();
        System.out.println(now);

        //formatter
            //时间转字符串
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("(yyyy)-MM-dd HH:mm:ss");
        String str=LocalDateTime.now().format(formatter);
        System.out.println(str);

            //字符串转时间
        String str2="(2003)-10-14 18:56:09";
        LocalDateTime parsed=LocalDateTime.parse(str2,formatter);
        System.out.println(parsed);
    }
}
