package com.vn.ec.service;


import com.vn.ec.common.Constants;
import com.vn.ec.common.exception.InvalidPasswordException;
import com.vn.ec.common.exception.RecordNotFoundException;
import com.vn.ec.dto.request.LoginRequest;
import com.vn.ec.dto.response.LoginResponse;
import com.vn.ec.entity.CustomerAccount;
import com.vn.ec.entity.CustomerProfiles;
import com.vn.ec.repository.CustomerAccountRepository;
import com.vn.ec.repository.CustomerProfilesRepository;
import com.vn.ec.security.jwt.JwtTokenUtil;
import com.vn.ec.utlis.EncryptAndDecrypt;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerProfilesRepository customerProfilesRepository;
    private final JwtTokenUtil jwtUtils;

    @SneakyThrows
    public LoginResponse login(LoginRequest loginRequest) {
        String loginId = loginRequest.getLoginId().strip();
        Optional<CustomerAccount> customerAccountOptional = customerAccountRepository.findByLoginIdAndDeleteFlag(loginId, false);
        if (customerAccountOptional.isEmpty())
            throw new RecordNotFoundException();

        CustomerAccount customerAccount = customerAccountOptional.get();
        String password = EncryptAndDecrypt.decrypt(customerAccount.getLoginPassword(),
                Constants.PASSWORD_AIR_WATER_DE);
        if (!password.equals(loginRequest.getPassword())) {
            throw new InvalidPasswordException(Constants.PASSWORD_ERROR);
        }
        String jwt = jwtUtils.generationJwtToken(loginId);
        CustomerProfiles customerProfiles =customerProfilesRepository.findByCustomerIdAndDeleteFlagFalse(customerAccount.getId());

        LoginResponse loginResponse1 = new LoginResponse();
        loginResponse1.setLoginId(loginId);
        loginResponse1.setAddress(customerProfiles.getDetailAddress());
        loginResponse1.setPoint(customerProfiles.getPoint());
        loginResponse1.setRank(customerProfiles.getRanking());
        loginResponse1.setToken(jwt);
        loginResponse1.setCustomerId(customerProfiles.getCustomerId());
        loginResponse1.setDistrictCode(customerProfiles.getDistrictCode());
        loginResponse1.setPhoneNumber(loginRequest.getLoginId());
        loginResponse1.setProvinceCode(customerProfiles.getProvinceCode());
//        LoginResponse loginResponse = LoginResponse.builder()
//                .customerId(customerInfoDto.getCustomerId())
//                .loginId(customerInfoDto.getLoginId())
//                .token(jwt)
//                .build();
        return loginResponse1;
    }
}
