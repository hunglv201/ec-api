package com.vn.ec.entity;

import com.vn.ec.common.CommonEntityColumn;
import com.vn.ec.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notifications extends CommonEntity {
    @Column(name = CommonEntityColumn.CUSTOMER_ID)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Long customerId;

    @Column(name = CommonEntityColumn.IMAGE_ID)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Integer imageId;

    @Column(name = CommonEntityColumn.TYPE)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Integer type;

    @Column(name = CommonEntityColumn.REDIRECT_URL)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_150, message = Constants.VALIDATE_MAX_SIZE_150)
    private String redirectUrl;

    @Column(name = CommonEntityColumn.SUMMARY)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    @Size(max = Constants.MAX_250, message = Constants.VALIDATE_MAX_SIZE_250)
    private String summary;

    @Column(name = CommonEntityColumn.UNREAD)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Boolean unread;

    @Column(name = CommonEntityColumn.CUSTOMER_GROUP_ID)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private Integer customerGroupId;

    @Column(name = CommonEntityColumn.PUBLIC_TIME)
    private Timestamp publicTime;

    @Column(name = CommonEntityColumn.CATEGORY)
    private Integer category;

    @Column(name = CommonEntityColumn.TITLE)
    @NotNull(message = Constants.VALIDATE_THE_FIELD)
    private String title;

}
