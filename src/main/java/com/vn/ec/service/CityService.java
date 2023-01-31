package com.vn.ec.service;

import com.vn.ec.dto.response.CityDto;
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
    public  List<CityDto> getCity(){
        return cityRepository.getAllV1();
    }
    public List<CityDto1> getCityV2(){
        List<ProvinceMasters> provinceMastersList = cityRepository.findAll();
        List<CityDto1> cityDto1s = new ArrayList<>();
        for (int i =0; i<provinceMastersList.size();i++){
            CityDto1 cityDto1 = new CityDto1();
            cityDto1.setProvinceCode(provinceMastersList.get(i).getProvinceCode());
            cityDto1.setProvinceName(provinceMastersList.get(i).getProvinceName());
            cityDto1s.add(cityDto1);
        }

        return cityDto1s;
    }
    public List<CityDto1> getCityV3(){
        return cityRepository.getAllV3();
    }

}
