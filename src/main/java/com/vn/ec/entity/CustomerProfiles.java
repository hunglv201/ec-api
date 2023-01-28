package com.vn.ec.entity;

import com.vn.ec.common.CommonEntityColumn;
import com.vn.ec.common.Constants;
import com.vn.ec.common.ConstantsTable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = ConstantsTable.CUSTOMER_PROFILES)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerProfiles extends CommonEntity {

    @Column(name = CommonEntityColumn.CUSTOMER_ID)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Long customerId;

    @Column(name = CommonEntityColumn.FULL_NAME)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private String fullName;

    @Column(name = CommonEntityColumn.BIRTH_DATE)
    private Date birthDate;

    @Column(name = CommonEntityColumn.GENDER)
    private Integer gender;

    @Column(name = CommonEntityColumn.PROVINCE_CODE)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)

    private String provinceCode;

    @Column(name = CommonEntityColumn.DISTRICT_CODE)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)

    private String districtCode;

    @Column(name = CommonEntityColumn.DETAIL_ADDRESS)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)

    private String detailAddress;

    @Column(name = CommonEntityColumn.POINT)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Integer point = 0;

    @Column(name = CommonEntityColumn.INVITE_CODE)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)

    private String inviteCode;

    @Column(name = CommonEntityColumn.INVITED_BY)
    private Long invitedBy;

    @Column(name = CommonEntityColumn.RANKING)
    private Integer ranking;

    @Column(name = CommonEntityColumn.INVITED_BRANCH)
    private Integer invitedBranch;

    @Column(name = CommonEntityColumn.NUMBER_DEPOSIT)
    private Integer numberDeposit;

    @Column(name = CommonEntityColumn.DEPOSIT_STATUS)
    private Integer depositStatus;
}
