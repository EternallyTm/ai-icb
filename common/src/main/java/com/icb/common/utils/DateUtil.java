package com.icb.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午3:20 2023/7/8
 */
public class DateUtil {

    public static ExecLocalDateTimeModel calculateMonthlyDates(LocalDate localDate) {
        LocalDate firstDayOfMonth = localDate.withDayOfMonth(1);

        // 计算当月最后一天
        LocalDate lastDayOfMonth = firstDayOfMonth.plusMonths(1).withDayOfMonth(1).minusDays(1);

        // 将时间设置为00:00
        LocalTime startTime = LocalTime.of(0, 0);
        LocalDateTime firstDayOfMonthStart = LocalDateTime.of(firstDayOfMonth, startTime);

        // 将时间设置为23:59
        LocalTime endTime = LocalTime.of(23, 59);
        LocalDateTime lastDayOfMonthEnd = LocalDateTime.of(lastDayOfMonth, endTime);
        return ExecLocalDateTimeModel.builder().firstDayOfMonthStart(firstDayOfMonthStart).lastDayOfMonthEnd(lastDayOfMonthEnd).build();
    }

    public static ExecLocalDateTimeModel calculateStartAndEndDates(LocalDate startLocalDate, LocalDate endLocalDate) {
        // 将时间设置为00:00
        LocalTime startTime = LocalTime.of(0, 0);
        LocalDateTime firstDayOfMonthStart = LocalDateTime.of(startLocalDate, startTime);

        // 将时间设置为23:59
        LocalTime endTime = LocalTime.of(23, 59);
        LocalDateTime lastDayOfMonthEnd = LocalDateTime.of(endLocalDate, endTime);
        return ExecLocalDateTimeModel.builder().firstDayOfMonthStart(firstDayOfMonthStart).lastDayOfMonthEnd(lastDayOfMonthEnd).build();
    }

    /**
     * 计算当前时间的一天的起止时间
     * @author: wangxing <1028106567@qq.com>
     * @param
     * @return
     */
    public static ExecLocalDateTimeModel calculateStartAndEndDatesOneDay(LocalDate localDate) {
        return calculateStartAndEndDates(localDate,localDate);
    }

    public static boolean isSameMonth(LocalDate currentDate, LocalDate inputDate) {
        return currentDate.getYear() == inputDate.getYear() && currentDate.getMonth() == inputDate.getMonth();
    }
}
