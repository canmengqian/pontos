package com.zzz.pontos.java.lambada.time;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    }
}
