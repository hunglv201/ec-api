package com.vn.ec.service;

import com.vn.ec.common.Constants;
import com.vn.ec.dto.ApiResponse;
import com.vn.ec.dto.request.SignUpRequest;
import com.vn.ec.entity.CustomerAccount;
import com.vn.ec.repository.CustomerAccountRepository;
import com.vn.ec.utlis.EncryptAndDecrypt;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SignUpService {
    private final CustomerAccountRepository customerAccountRepository;

    public ApiResponse signUp(SignUpRequest request) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        Optional<CustomerAccount> customerAccountOptional = customerAccountRepository.findByLoginIdAndDeleteFlag(request.getLoginId(),false);
        if (customerAccountOptional.isPresent()) {
            return new ApiResponse(Constants.HTTP_CODE_400, Constants.NONE_COMPLETE, "Phone number already exists");
        }
        String encodedNewPwd = EncryptAndDecrypt.encrypt(request.getPassword().getBytes(StandardCharsets.UTF_8),
                Constants.PASSWORD_AIR_WATER_DE);
        CustomerAccount customerAccount1 = new CustomerAccount();
        customerAccount1.setLoginId(request.getLoginId());
        customerAccount1.setLoginPassword(encodedNewPwd);
        customerAccount1.setCommonRegister(0L);
        customerAccountRepository.save(customerAccount1);
        return ApiResponse.apiResponseCompleted();
    }
}
