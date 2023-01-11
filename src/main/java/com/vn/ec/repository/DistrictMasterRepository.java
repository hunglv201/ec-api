package com.vn.ec.repository;


import com.vn.ec.dto.response.Aip2Response;
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

}
