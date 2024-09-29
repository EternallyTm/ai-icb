package com.icb.sso.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 用户权限model 可扩展角色数据存储
 * @Author: wangxing <1028106567@qq.com>
 * @Date: Created in 下午5:05 2023/7/1
 */
@Data
public class UserAuthBO implements Serializable {

    private Long userId;

    private List<String> permissionCodes;
}
