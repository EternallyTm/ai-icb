package com.icb.mdm.bo;

import com.icb.common.model.BaseBO;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserBO extends BaseBO implements Serializable {

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
     * 密码
     */
    private String password;

    /**
     * 企业名称
     */
    private String companyName;
}
