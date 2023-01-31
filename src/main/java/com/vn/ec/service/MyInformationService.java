package com.vn.ec.service;

import com.vn.ec.dto.response.MyInformationResponse;
import com.vn.ec.repository.MyInformationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyInformationService {
    private final MyInformationRepository myInformationRepository;
    public MyInformationResponse myInformation(Long userId) {
        return myInformationRepository.getInformation(userId);
    }
}
