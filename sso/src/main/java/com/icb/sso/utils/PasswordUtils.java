package com.icb.sso.utils;

import cn.hutool.crypto.SmUtil;
import org.apache.commons.lang3.StringUtils;

public class PasswordUtils {

    public static String sm3(String password) {
        return SmUtil.sm3(password).toLowerCase();
    }

    public static boolean isMatch(String inputPassword, String dbPassword) {
        return StringUtils.equals(sm3(inputPassword),dbPassword);
    }
}
