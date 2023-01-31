package com.vn.ec.repository;

import com.vn.ec.dto.response.MyInformationResponse;
import com.vn.ec.entity.CustomerProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyInformationRepository extends JpaRepository<CustomerProfiles, Long> {
    @Query(value =  "select cp.full_name        as fullName,\n" +
            "       pm.province_name    as provinceName,\n" +
            "       dm.district_name    as districtName,\n" +
            "       cp.province_code    as provinceCode,\n" +
            "       cp.district_code    as districtCode,\n" +
            "       cp.detail_address   as address,\n" +
            "       cp.birth_date       as birthDate,\n" +
            "       cp.gender           as gender,\n" +
            "       cp.point            as point,\n" +
            "       cp.invite_code      as inviteCode,\n" +
            "       rm.name             as rankName,\n" +
            "       rm.discount_percent as rankDiscountPercent,\n" +
            "       img.image_url       as rankImageUrl\n" +
            "from customer_profiles cp\n" +
            "         left join\n" +
            "     PROVINCE_MASTERS pm\n" +
            "     on pm.PROVINCE_CODE = cp.PROVINCE_CODE\n" +
            "         left join\n" +
            "     DISTRICT_MASTERS dm\n" +
            "     on dm.PROVINCE_CODE = cp.PROVINCE_CODE\n" +
            "         and dm.DISTRICT_CODE = cp.DISTRICT_CODE\n" +
            "         left join\n" +
            "     CUSTOMER_ACCOUNTS ca\n" +
            "     on ca.id = cp.customer_id\n" +
            "         and ca.delete_flag = false\n" +
            "         left join\n" +
            "     RANK_MASTER rm\n" +
            "     on rm.id = cp.ranking\n" +
            "         left join\n" +
            "     IMAGES img\n" +
            "     on img.id = rm.IMAGE_ID\n" +
            "where cp.customer_id =:userId\n" +
            "  and cp.delete_flag = false ", nativeQuery = true)
    MyInformationResponse  getInformation(Long userId);
}
