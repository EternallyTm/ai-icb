package com.icb.sso.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 校验用户权限model
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午12:10 2023/7/2
 */
@Data
public class CheckUserAuthCodeBO implements Serializable {

    private Long userId;

    private List<String> authCodes;

}
