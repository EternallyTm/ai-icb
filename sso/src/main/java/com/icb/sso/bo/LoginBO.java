package com.icb.sso.bo;

import com.icb.sso.emuns.LoginTypeEnum;
import lombok.Data;
import java.io.Serializable;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午2:06 2023/7/1
 */
@Data
public class LoginBO implements Serializable {

    private String username;

    private String password;

    private String emailCode;

    private LoginTypeEnum type;

    private SsoUserBO ssoUserBO;

    /*记住我*/
    private Boolean autoLogin;
}
