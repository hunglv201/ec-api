package com.vn.ec.dto.response;

import com.vn.ec.common.validator.JsonFormatDate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class MyInformationResponse {
    private String fullName;
    private String provinceCode;
    private String provinceName;
    private String districtCode;
    private String districtName;
    private String detailAddress;
    @JsonFormatDate
    private Date birthDate;
    private Integer gender;
    private String phoneNumber;
    private Integer point;
    private String inviteCode;
    private RankingInfoResponse ranKing;
    public MyInformationResponse(String fullName,
                                 String provinceCode,
                                 String provinceName,
                                 String districtCode,
                                 String districtName,
                                 String detailAddress,
                                 Date birthDate,
                                 Integer gender,
                                 String phoneNumber,
                                 Integer point,
                                 String inviteCode,
                                 String name,
                                 String imageUrl,
                                 Integer discountPercent) {
        this.fullName = fullName;
        this.provinceCode = provinceCode;
        this.provinceName = provinceName;
        this.districtCode = districtCode;
        this.districtName = districtName;
        this.detailAddress = detailAddress;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.point = point;
        this.inviteCode = inviteCode;
        this.ranKing = new RankingInfoResponse(name, imageUrl, discountPercent);
    }
}
