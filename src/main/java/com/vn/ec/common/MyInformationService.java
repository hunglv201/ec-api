package com.vn.ec.common;

import com.vn.ec.dto.ApiResponse;
import com.vn.ec.repository.MyInformationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyInformationService {
    private final MyInformationRepository myInformationRepository;
    public ApiResponse myInformation(Long userId) {
        return ApiResponse.apiResponseCompleted(myInformationRepository.getInformation(userId));
    }
}
