package com.alibaba.jdk.features;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * 新特性5-DateTime API
 */
public class Feature5 {

    static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void newDateTime() {
        //format yyyy-MM-dd
        LocalDate nowDate = LocalDate.now();
        System.out.println("Now Date: " + nowDate);

        //format HH:mm:ss
        LocalTime nowTime = LocalTime.now().withNano(0);
        System.out.println("Now Time: " + nowTime);

        //format yyyy-MM-dd HH:mm:ss
        String nowDateTime = LocalDateTime.now().format(DATETIME_FORMATTER);
        System.out.println("Now DateTime: " + nowDateTime);

        // ZonedDateTime = LocalDateTime + ZoneId
        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        System.out.println("Now ZonedDateTime: " + nowZonedDateTime);

        ZoneId zoneId = ZoneId.of(ZoneId.SHORT_IDS.get("PST"));
        ZonedDateTime losAngelesDateTime = nowZonedDateTime.withZoneSameInstant(zoneId);
        System.out.println("=> To Los Angeles ZonedDateTime: " + losAngelesDateTime);

        LocalDateTime localDateTime = losAngelesDateTime.toLocalDateTime();
        System.out.println("=> To America/Los_Angeles LocalDateTime(without TimeZone): " + localDateTime);

        ZonedDateTime localZoned = localDateTime.atZone(ZoneId.systemDefault());
        System.out.println("=> To Asia/Shanghai ZonedDateTime: " + localZoned);
    }

    public void string2DateTime() {
        LocalDate date = LocalDate.of(2025, 4, 19);
        LocalDate ld = LocalDate.parse("2025-04-19");
        System.out.println(date.equals(ld));

        LocalTime time = LocalTime.of(20, 56, 17);
        LocalTime lt = LocalTime.parse("20:56:17");
        System.out.println(time.equals(lt));

        LocalDateTime dateTime = LocalDateTime.of(2025, 4, 19, 20, 56, 17);
        LocalDateTime ldt = LocalDateTime.parse("2025-04-19 20:56:17", DATETIME_FORMATTER);
        System.out.println(dateTime.equals(ldt));
    }

    public void calcDateTime() {
        LocalDate nowDate = LocalDate.now();

        LocalDate nextWeek1 = nowDate.plus(1, ChronoUnit.WEEKS);
        System.out.println(nextWeek1);

        LocalDate nextWeek2 = nowDate.plusWeeks(1);
        System.out.println(nextWeek2);

        LocalDate onboarding = LocalDate.parse("2024-12-23");
        LocalDate working = LocalDate.parse("2025-04-19");
        Period period = Period.between(onboarding, working);
        System.out.println("From 2024-12-23 to 2025-04-19: " + period.getYears() + "年 " + period.getMonths() + "月 " + period.getDays() + "天");

        long days = working.toEpochDay() - onboarding.toEpochDay();
        System.out.println("From 2024-12-23 to 2025-04-19: " + days + "天");
    }


    public void getSomeDay() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First Day Of Month: " + firstDayOfMonth);

        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Last Day Of Month: " + lastDayOfMonth);

        LocalDate firstDayOfNextMonth = lastDayOfMonth.plusDays(1);
        System.out.println("First Day Of Next Month: " + firstDayOfNextMonth);

        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last Day Of Year: " + lastDayOfYear);

        LocalDate lastMondayOf2025 = LocalDate.parse("2025-12-31").with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("Last Monday Of 2025: " + lastMondayOf2025);
    }


    public void jdbcDate() {
        // MySQL Date -> LocalDate
        // MySQL Time -> LocalTime
        // MySQL Timestamp -> LocalDateTime
    }
}
