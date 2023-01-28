package com.vn.ec.common;

import com.vn.ec.common.exception.RecordNotFoundException;
import com.vn.ec.dto.ApiResponse;
import com.vn.ec.entity.CustomerAccount;
import com.vn.ec.repository.CustomerAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerAccountService {
    private final CustomerAccountRepository customerAccountRepository;
    public ApiResponse deleteAccount(Long id) {
        CustomerAccount customerAccount = customerAccountRepository.findByIdAndDeleteFlag(id, Constants.DELETE_FALSE)
                .orElseThrow(()-> new RecordNotFoundException("user account not fount"));
        customerAccount.setCommonDelete(id);
        customerAccountRepository.save(customerAccount);
        return ApiResponse.apiResponseCompleted();
    }

    public ApiResponse deleteAccountV2(Long id) {
        CustomerAccount customerAccount = customerAccountRepository.getbyid(id);
        if (customerAccount==null){
            throw new RecordNotFoundException("user account not fount");
        }
        customerAccount.setCommonDelete(id);
        customerAccountRepository.save(customerAccount);
        return ApiResponse.apiResponseCompleted();
    }

}
