package com.vn.ec.service;


import com.vn.ec.common.Constants;
import com.vn.ec.common.exception.InvalidPasswordException;
import com.vn.ec.common.exception.RecordNotFoundException;
import com.vn.ec.dto.ApiResponse;
import com.vn.ec.dto.response.CustomerInfoDto;
import com.vn.ec.dto.request.LoginRequest;
import com.vn.ec.dto.response.LoginResponse;
import com.vn.ec.repository.CustomerAccountRepository;
import com.vn.ec.security.jwt.JwtTokenUtil;
import com.vn.ec.utlis.EncryptAndDecrypt;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {
    private final CustomerAccountRepository customerAccountRepository;
    private final JwtTokenUtil jwtUtils;

    @SneakyThrows
    public ApiResponse login(LoginRequest loginRequest) {
        String loginId = loginRequest.getLoginId().strip();
        CustomerInfoDto customerInfoDto = customerAccountRepository.findCustomerForLogin(loginId);
        if (customerInfoDto == null)
            throw new RecordNotFoundException();
        String password = EncryptAndDecrypt.decrypt(customerInfoDto.getPassword(),
                Constants.PASSWORD_AIR_WATER_DE);
        if (!password.equals(loginRequest.getPassword())) {
            throw new InvalidPasswordException(Constants.PASSWORD_ERROR);
        }
        String jwt = jwtUtils.generationJwtToken(loginId);
        LoginResponse loginResponse = LoginResponse.builder()
                .customerId(customerInfoDto.getCustomerId())
                .loginId(customerInfoDto.getLoginId())
                .token(jwt)
                .build();
        return ApiResponse.apiResponseCompleted(loginResponse);
    }
}
