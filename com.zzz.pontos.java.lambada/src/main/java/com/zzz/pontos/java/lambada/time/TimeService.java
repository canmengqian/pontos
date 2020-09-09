package com.zzz.pontos.java.lambada.time;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;


/**
 * @ClassName TimeService
 * @Description TODO
 * @Author 25703
 * @Date 2020/9/4 17:10
 * @Version 1.0.0
 **/
public class TimeService {
    @Test
    public void test_time() {
        LocalDate localDate = LocalDate.now(Clock.systemDefaultZone());
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getLong(ChronoField.DAY_OF_MONTH));
        System.out.println(localDate.getMonth().getValue());
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        // 使用时区
        ZonedDateTime date1 = ZonedDateTime.parse("2020-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);
        //巴黎
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        //当前时区
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当前时区: " + currentZone);
    }
}
