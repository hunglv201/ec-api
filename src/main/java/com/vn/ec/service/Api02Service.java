package com.vn.ec.service;

import com.vn.ec.dto.response.Aip2Response;
import com.vn.ec.dto.response.Api2ResponseV2;
import com.vn.ec.entity.DistrictMaster;
import com.vn.ec.repository.DistrictMasterRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class Api02Service {
    private final DistrictMasterRepository api02Repository;
    private final ModelMapper mapper;
    public List<Aip2Response> getDistrict(String id) {
        return api02Repository.getDistrict(id);
    }
    public List<Api2ResponseV2> getDistrictV2(String id) {
        List<DistrictMaster> districtMasterList = api02Repository.findAllByProvinceCodeAndDeleteFlagFalse(id);
//        List<Api2ResponseV2> api2ResponseV2s = new ArrayList<>();
        List<Api2ResponseV2> postDtoList = Arrays.asList(mapper.map(districtMasterList, Api2ResponseV2[].class));
//        for (int i =0; i<districtMasterList.size();i++){
////            Api2ResponseV2 api2ResponseV2 = new Api2ResponseV2();
////            api2ResponseV2.setDistrictCode(districtMasterList.get(i).getDistrictCode());
////            api2ResponseV2.setDistrictName(districtMasterList.get(i).getDistrictName());
//            Api2ResponseV2 api2ResponseV2 = mapper.map(districtMasterList.get(i),Api2ResponseV2.class );
//            api2ResponseV2s.add(api2ResponseV2);
//        }
        return postDtoList;
    }
    public List<Aip2Response> getDistrictV3(String id){
        return api02Repository.getDistrictV3(id);
    }

}
