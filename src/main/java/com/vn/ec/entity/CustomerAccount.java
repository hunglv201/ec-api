package com.vn.ec.entity;

import com.vn.ec.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_accounts")
public class CustomerAccount extends CommonEntity {
    @Column(name = "login_id")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_30, message = Constants.VALIDATE_MAX_SIZE_30)
    private String loginId;

    @Column(name = "login_password")
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_120, message = Constants.VALIDATE_MAX_SIZE_120)
    private String loginPassword;



}
