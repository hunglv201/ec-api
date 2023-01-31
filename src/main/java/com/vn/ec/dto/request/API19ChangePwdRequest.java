package com.vn.ec.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class API19ChangePwdRequest {
    @NotNull
    private Long userId;
    @NotNull
    private String oldPassword;
    @NotNull
    private String newPassword;
}
