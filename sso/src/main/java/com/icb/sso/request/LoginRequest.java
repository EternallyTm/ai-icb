package com.icb.sso.request;


import com.icb.sso.emuns.LoginTypeEnum;
import lombok.Data;
import java.io.Serializable;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午2:06 2023/7/1
 */
@Data
public class LoginRequest implements Serializable {

    private String username;

    private String password;

    private String emailCode;

    private LoginTypeEnum type;

    private Boolean autoLogin = Boolean.FALSE;
}
