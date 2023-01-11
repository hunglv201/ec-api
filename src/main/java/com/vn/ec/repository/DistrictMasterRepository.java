package com.vn.ec.repository;


import com.vn.ec.dto.response.Aip2Response;
import com.vn.ec.dto.response.Api2ResponseV2;
import com.vn.ec.dto.response.CityDto1;
import com.vn.ec.entity.DistrictMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DistrictMasterRepository extends JpaRepository<DistrictMaster, Long> {
    @Query(value = "SELECT  dm.DISTRICT_CODE as id, dm.DISTRICT_NAME as name\n" +
            "FROM DISTRICT_MASTERS dm\n" +
            "WHERE dm.province_Code =:id AND dm.delete_Flag = false", nativeQuery = true)
    List<Aip2Response> getDistrict(String id);
    List<Api2ResponseV2> findAllByProvinceCodeAndDeleteFlagFalse(String code);
    @Query(value = "SELECT dm.districtCode AS id, dm.districtName as name\n" +
            " FROM DistrictMaster  dm\n" +
            "WHERE dm.provinceCode =:id AND dm.deleteFlag = false")
    List<Aip2Response> getDistrictV3(String id);


}
