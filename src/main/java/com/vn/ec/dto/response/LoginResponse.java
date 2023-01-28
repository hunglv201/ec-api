package com.vn.ec.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {
    private Long customerId;
    private String loginId;
    private String token;
    private Integer rank;
    private Integer point;
    private String provinceCode;
    private String districtCode;
    private String address;
    private String phoneNumber;
}
