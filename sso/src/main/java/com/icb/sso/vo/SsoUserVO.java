package com.icb.sso.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午10:08 2023/6/28
 */
@Data
public class SsoUserVO implements Serializable {

    private Long id;

    private String name;

    private String username;

    private String email;

    private String mobile;

    private Long companyId;

    private String companyName;

    private String avatar;

    private List<String> permissionCodes;
}
