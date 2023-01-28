package com.vn.ec.repository;

import com.vn.ec.entity.CustomerProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerProfilesRepository extends JpaRepository<CustomerProfiles, Long> {

    CustomerProfiles findByCustomerIdAndDeleteFlagFalse(Long customerId);
    CustomerProfiles findFirstByInviteCodeAndDeleteFlag(String code, Boolean deleteFlag);

}
