package com.icb.mdm.vo.sso;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {

    /**
     * 主键
     */

    private Long id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 登录名：默认使用邮箱作为登录名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 0-未启用 1-已启用
     */
    private Integer status;

    /**
     * 账号类型：1-运营账号 2-外部账号
     */
    private Integer type;

    /**
     * 企业ID
     */
    private Long companyId;

    /**
     * 企业名称
     */
    private String companyName;
}
