package com.icb.sso.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:39 2023/7/9
 */
@Data
public class AuthBO implements Serializable {

    private String permissionCode;
}
