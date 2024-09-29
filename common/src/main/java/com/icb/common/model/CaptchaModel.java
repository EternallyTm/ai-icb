package com.icb.common.model;

import lombok.Builder;
import lombok.Data;

import java.awt.image.BufferedImage;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午8:41 2023/7/7
 */
@Data
@Builder
public class CaptchaModel {

    /*验证码图片*/
    private BufferedImage captchaImage;

    /*验证码的code*/
    private String code;
}
