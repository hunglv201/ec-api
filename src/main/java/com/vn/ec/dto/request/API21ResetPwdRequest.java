package com.vn.ec.dto.request;

import com.vn.ec.common.validator.PhoneNumberValid;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class API21ResetPwdRequest {
    @NotNull
    @PhoneNumberValid
    private String loginId;
    @NotNull
    private String password;
    private String otp;
}
