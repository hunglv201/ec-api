package com.vn.ec.repository;

import com.vn.ec.dto.response.CustomerInfoDto;
import com.vn.ec.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
    Optional<CustomerAccount> findByLoginIdAndDeleteFlag(String username, Boolean deleteFlag);
    Optional<CustomerAccount> findByIdAndDeleteFlag(Long userId, Boolean delFlag);

    @Query(value = "select ca.id      as customerId,\n" +
            "       ca.login_id as loginId, " +
            "       ca.login_password as password " +
            "from customer_accounts as ca\n" +
            "where ca.delete_flag = false\n" +
            "  and ca.login_id =:loginId ", nativeQuery = true)
    CustomerInfoDto findCustomerForLogin(String loginId);

    @Query(value = "select * from customer_accounts where id=:id and delete_flag= false", nativeQuery = true)
    CustomerAccount getbyid(Long id);


}
