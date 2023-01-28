package com.vn.ec.entity;

import com.vn.ec.common.Constants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "branches")
public class Branches extends CommonEntity  {

    @Column(name = "company_id")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Long companyId;

    @Column(name = "branch_name")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_60, message = Constants.VALIDATE_MAX_SIZE_60)
    private String branchName;

    @Column(name =  "branch_short_name")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_30, message = Constants.VALIDATE_MAX_SIZE_30)
    private String branchShortName;

    @Column(name = "branch_kind")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Integer branchKind;

    @Column(name = "regist_cd")
    @Size(max = Constants.MAX_3, message = Constants.VALIDATE_MAX_SIZE_3)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private String reGistCd;

    @Column(name ="province_code")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_5, message = Constants.VALIDATE_MAX_SIZE_5)
    private String provinceCode;

    @Column(name = "district_code")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_5, message = Constants.VALIDATE_MAX_SIZE_5)
    private String districtCode;

    @Column(name ="address")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_250, message = Constants.VALIDATE_MAX_SIZE_250)
    private String address;

    @Column(name = "availability_flag")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Boolean availabilityFlag = true;
}
