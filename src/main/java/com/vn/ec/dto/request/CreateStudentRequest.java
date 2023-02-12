package com.vn.ec.dto.request;

import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class CreateStudentRequest {

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
