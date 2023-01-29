package com.vn.ec.repository;

import com.vn.ec.dto.response.MyInformationResponse;
import com.vn.ec.entity.CustomerProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyInformationRepository extends JpaRepository<CustomerProfiles, Long> {
    @Query(value =  "select  cp.full_name   as fullName,\n" +
            "cp.province_name  as provinceName,\n" +
            "cp.district_name  as districtName,\n" +
            "cp.detail_address as address,\n" +
            "cp.birth_date as birthDate,\n" +
            "cp.gender   as gender,\n" +
            "cp.point          as point,\n" +
            "cp.invite_code   as inviteCode,\n" +
            "cp.ranking        as rank,\n" +
            "from customer_profiles cp \n" +
            "left join PROVINCE_MASTERS pm on pm.PROVINCE_CODE = cp.PROVINCE_CODE \n"+
            "left join DISTRICT_MASTERS dm on dm.PROVINCE_CODE = cp.PROVINCE_CODE " +
            "and dm.DISTRICT_CODE=cp.DISTRICT_CODE \n"+
            "left join CUSTOMER_ACCOUNTS ca on ca.id = cp.customer_id and ca.delete_flag = false\n"+
            "left join RANK_MASTER rm on rm.id = cp.ranking \n"+
            "left join IMAGES img on img.id = rm.IMAGE_ID \n"+
            "where cp.customer_id=:userId and cp.delete_flag = false\n ", nativeQuery = true)
    MyInformationResponse getInformation(Long userId);
}
