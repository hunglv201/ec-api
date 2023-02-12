package com.vn.ec.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class API51UpdatePwdRequest {

    @NotBlank
    private String fullName;
    @NotNull
    private Date birthDay;
    @NotBlank
    private String className;
    @NotBlank
    private String major;
    @NotBlank
    private String hometown ;
    @NotBlank
    private String gender;
    private Float averageMark;
}
