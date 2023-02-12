package com.vn.ec.entity;

import com.vn.ec.common.CommonEntityColumn;
import com.vn.ec.common.Constants;
import com.vn.ec.common.ConstantsTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = ConstantsTable.PRODUCTS)
public class Products extends CommonEntity{
    @Column(name = CommonEntityColumn.NAME)
    @NotNull
    @Size(max = Constants.MAX_60, message = Constants.VALIDATE_MAX_SIZE_60)
    private String name;

    @Column(name = CommonEntityColumn.DESCRIPTION)
    @Size(max = Constants.MAX_500, message = Constants.VALIDATE_MAX_SIZE_500)
    private String description;

    @Column(name = CommonEntityColumn.AVAILABLE_FLAG)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Boolean availableFlag = false;

    @Column(name = CommonEntityColumn.PRICE)
    @NotNull
    private Integer price;

    @Column(name = CommonEntityColumn.IMAGE_ID)
    @NotNull
    private Integer imageId;
}
