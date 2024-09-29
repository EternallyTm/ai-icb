package com.icb.sso.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SsoUserBO implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String username;

    private String email;

    private String mobile;

    private Long companyId;

    private String companyName;

    private Integer companyStatus;

    private Integer status;

    private Integer type;
}
