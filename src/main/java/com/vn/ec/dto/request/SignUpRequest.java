package com.vn.ec.dto.request;

import com.vn.ec.common.Constants;
import com.vn.ec.common.validator.PhoneNumberValid;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SignUpRequest {
    @NotBlank(message = Constants.VALIDATE_THE_FIELD)
    @PhoneNumberValid
    private String  loginId;
    @NotBlank(message = Constants.VALIDATE_THE_FIELD)
    private String fullName;
    @NotBlank(message = Constants.VALIDATE_THE_FIELD)
    private String password;
    @NotBlank(message = Constants.VALIDATE_THE_FIELD)
    private String provinceCode;
    @NotBlank(message = Constants.VALIDATE_THE_FIELD)
    private String districtCode;
    @NotBlank(message = Constants.VALIDATE_THE_FIELD)
    private String detailAddress ;
    private String birthday;
    private String inviteCode;
    private Integer inviteBranch;
}
