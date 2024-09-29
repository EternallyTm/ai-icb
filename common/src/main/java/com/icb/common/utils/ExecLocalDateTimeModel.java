package com.icb.common.utils;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午3:18 2023/7/8
 */
@Data
@Builder
public class ExecLocalDateTimeModel {

    private LocalDateTime firstDayOfMonthStart;

    private LocalDateTime lastDayOfMonthEnd;
}
