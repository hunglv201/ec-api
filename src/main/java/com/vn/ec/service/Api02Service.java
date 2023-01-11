package com.vn.ec.service;

import com.vn.ec.dto.ApiResponse;
import com.vn.ec.dto.response.CityDto1;
import com.vn.ec.entity.ProvinceMasters;
import com.vn.ec.repository.DistrictMasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Api02Service {
    private final DistrictMasterRepository api02Repository;
    public ApiResponse getDistrict(String id) {
        return ApiResponse.apiResponseCompleted(api02Repository.getDistrict(id));
    }
    public ApiResponse getDistrictV2(String id) {
        return ApiResponse.apiResponseCompleted(api02Repository.findAllByProvinceCodeAndDeleteFlagFalse(id));
    }
    public ApiResponse getDistrictV3(String id){
        return ApiResponse.apiResponseCompleted(api02Repository.getDistrictV3(id));
    }

}
