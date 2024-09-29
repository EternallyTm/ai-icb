package com.icb.common.utils;



import com.icb.common.model.CaptchaModel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 *  图形验证码生成工具
 * @author: wangxing <1028106567@qq.com>
 */
public class CaptchaGenerator {
    private static final int WIDTH = 200; // 图片宽度
    private static final int HEIGHT = 80; // 图片高度
    private static final int CODE_LENGTH = 4; // 验证码长度
    private static final String CODE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // 验证码字符集

    public static CaptchaModel generateCaptcha() {
        // 创建一个新的图像缓冲区
        BufferedImage captchaImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        // 获取图形上下文对象
        Graphics graphics = captchaImage.getGraphics();

        // 生成随机对象
        Random random = new Random();

        // 设置背景色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        // 生成验证码字符串
        StringBuilder captchaCode = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CODE_CHARACTERS.length());
            char randomChar = CODE_CHARACTERS.charAt(randomIndex);
            captchaCode.append(randomChar);
        }

        // 绘制验证码字符串
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 40));
        graphics.drawString(captchaCode.toString(), 50, 50);

        // 添加干扰线
        for (int i = 0; i < 5; i++) {
            int startX = random.nextInt(WIDTH);
            int startY = random.nextInt(HEIGHT);
            int endX = random.nextInt(WIDTH);
            int endY = random.nextInt(HEIGHT);
            graphics.setColor(getRandomColor());
            graphics.drawLine(startX, startY, endX, endY);
        }

        // 添加噪点
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            graphics.setColor(getRandomColor());
            graphics.fillRect(x, y, 1, 1);
        }

        // 释放图形上下文资源
        graphics.dispose();
        return CaptchaModel.builder()
                .captchaImage(captchaImage)
                .code(captchaCode.toString())
                .build();
    }

    private static Color getRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}
