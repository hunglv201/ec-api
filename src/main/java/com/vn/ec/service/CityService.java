package com.vn.ec.service;

import com.vn.ec.dto.ApiResponse;
import com.vn.ec.dto.response.CityDto1;
import com.vn.ec.entity.ProvinceMasters;
import com.vn.ec.repository.ProvinceMasterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final ProvinceMasterRepository cityRepository;
    public ApiResponse getCity(){
        return ApiResponse.apiResponseCompleted(cityRepository.getAllV1());
    }
    public ApiResponse getCityV2(){
        List<ProvinceMasters> provinceMastersList = cityRepository.findAll();
        List<CityDto1> cityDto1s = new ArrayList<>();
        for (int i =0; i<provinceMastersList.size();i++){
            CityDto1 cityDto1 = new CityDto1();
            cityDto1.setProvinceCode(provinceMastersList.get(i).getProvinceCode());
            cityDto1.setProvinceName(provinceMastersList.get(i).getProvinceName());
            cityDto1s.add(cityDto1);
        }

        return ApiResponse.apiResponseCompleted(cityDto1s);
    }
    public ApiResponse getCityV3(){
        return ApiResponse.apiResponseCompleted(cityRepository.getAllV3());
    }

}
