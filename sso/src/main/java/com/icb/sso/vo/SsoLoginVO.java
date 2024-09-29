package com.icb.sso.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SsoLoginVO implements Serializable {

    private String token;
}
