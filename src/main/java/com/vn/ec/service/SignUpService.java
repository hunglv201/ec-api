package com.vn.ec.service;

import com.vn.ec.common.Constants;
import com.vn.ec.dto.request.SignUpRequest;
import com.vn.ec.entity.CustomerAccount;
import com.vn.ec.entity.CustomerProfiles;
import com.vn.ec.repository.CustomerAccountRepository;
import com.vn.ec.repository.CustomerProfilesRepository;
import com.vn.ec.utlis.EncryptAndDecrypt;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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

import static com.vn.ec.utlis.Utils.genRandomString;

@Service
@AllArgsConstructor
public class SignUpService {
    private final CustomerAccountRepository customerAccountRepository;
    private final CustomerProfilesRepository customerProfilesRepository;
    @Transactional
    public String signUp(SignUpRequest request) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        Optional<CustomerAccount> customerAccountOptional = customerAccountRepository.findByLoginIdAndDeleteFlag(request.getLoginId(),false);
        if (customerAccountOptional.isPresent()) {
            return "Phone number already exists";
        }
        //        tạo mã mời và kiểm tra mã mời
        Long inviteBy = null;
        boolean isDuplicated = false;
        String inviteCode;
        do {
            inviteCode = genRandomString();
            CustomerProfiles customerProfiles = customerProfilesRepository.findFirstByInviteCodeAndDeleteFlag(inviteCode, Constants.DELETE_FALSE);
            if (customerProfiles != null) {
                isDuplicated = true;
            }
        } while (isDuplicated);
        if (!StringUtils.isBlank(request.getInviteCode())) {
            CustomerProfiles customerProfiles = customerProfilesRepository.findFirstByInviteCodeAndDeleteFlag(request.getInviteCode(), Constants.DELETE_FALSE);
            if (customerProfiles != null)
                inviteBy = customerProfiles.getCustomerId();
        }

        String encodedNewPwd = EncryptAndDecrypt.encrypt(request.getPassword().getBytes(StandardCharsets.UTF_8),
                Constants.PASSWORD_AIR_WATER_DE);
        CustomerAccount customerAccount1 = new CustomerAccount();
        customerAccount1.setLoginId(request.getLoginId());
        customerAccount1.setLoginPassword(encodedNewPwd);
        customerAccount1.setCommonRegister(0L);
        customerAccountRepository.save(customerAccount1);

        CustomerProfiles customerProfiles1 = new CustomerProfiles();
        customerProfiles1.setCustomerId(customerAccount1.getId());
        customerProfiles1.setFullName(request.getFullName());
        customerProfiles1.setProvinceCode(request.getProvinceCode());
        customerProfiles1.setDistrictCode(request.getDistrictCode());
        customerProfiles1.setDetailAddress(request.getDetailAddress());
        customerProfiles1.setPoint(0);
        customerProfiles1.setInviteCode(inviteCode);
        customerProfiles1.setInvitedBy(inviteBy);
        customerProfiles1.setCommonRegister(0L);
        customerProfilesRepository.save(customerProfiles1);
        return "Completed";
    }
}
