package com.icb.sso.bo;

import cn.hutool.core.bean.BeanUtil;
import com.icb.sso.vo.SsoLoginVO;
import com.icb.sso.vo.SsoUserVO;
import lombok.Data;

import java.io.Serializable;

@Data
public class SsoLoginResBO implements Serializable {

    private String token;
    public SsoLoginVO toSsoUserVO() {
        SsoLoginVO ssoLoginVO = new SsoLoginVO();
        ssoLoginVO.setToken(this.token);
        return ssoLoginVO;
    }
}
