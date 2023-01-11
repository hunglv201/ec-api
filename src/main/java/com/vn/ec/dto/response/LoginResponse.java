package com.vn.ec.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private Long customerId;
    private String loginId;
    private String token;
}
