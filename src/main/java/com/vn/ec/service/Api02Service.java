package com.vn.ec.service;

import com.vn.ec.dto.ApiResponse;
import com.vn.ec.repository.DistrictMasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Api02Service {
    private final DistrictMasterRepository api02Repository;
    public ApiResponse getDistrict(String id) {
        return ApiResponse.apiResponseCompleted(api02Repository.getDistrict(id));
    }

}
