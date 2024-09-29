package com.icb.sso.api.entity;

import lombok.Data;

@Data
public class SsoUserDTO {

    private Long id;

    private String name;

    private String username;

    private String email;

    private String mobile;

    private Long companyId;

    private String companyName;

    private String avatar;

    private Integer type;
}
