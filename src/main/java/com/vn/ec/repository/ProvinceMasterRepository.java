package com.vn.ec.repository;

import com.vn.ec.dto.response.CityDto;
import com.vn.ec.dto.response.CityDto1;
import com.vn.ec.entity.ProvinceMasters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProvinceMasterRepository extends JpaRepository<ProvinceMasters, Long> {
    List<ProvinceMasters> findAll();
    @Query(value = "SELECT  pm.province_code as id, pm.province_name as name\n" +
            "FROM province_masters pm\n" +
            "WHERE pm.delete_flag = false", nativeQuery = true)
    List<CityDto> getAllV1();

    @Query(value = "SELECT  new com.vn.ec.dto.response.CityDto1(provinceCode, provinceName) from ProvinceMasters " +
            "where deleteFlag = false ")
    List<CityDto1> getAllV3();


}
