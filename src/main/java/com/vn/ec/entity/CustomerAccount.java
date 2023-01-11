package com.vn.ec.entity;

import com.vn.ec.common.Constants;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "customer-accounts")
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
