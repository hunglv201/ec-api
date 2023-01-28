package com.vn.ec.entity;

import com.vn.ec.common.CommonEntityColumn;
import com.vn.ec.common.Constants;
import com.vn.ec.common.ConstantsTable;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = ConstantsTable.PROVINCE_MASTERS)
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceMasters extends CommonEntity {

    @Column(name = CommonEntityColumn.PROVINCE_CODE)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_5, message = Constants.VALIDATE_MAX_SIZE_5)
    private String provinceCode;

    @Column(name = CommonEntityColumn.PROVINCE_NAME)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_60, message = Constants.VALIDATE_MAX_SIZE_60)
    private String provinceName;
}
