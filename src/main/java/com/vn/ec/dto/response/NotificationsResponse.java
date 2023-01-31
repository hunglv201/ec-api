package com.vn.ec.dto.response;

import com.vn.ec.common.validator.JsonFormatDate;

import java.util.Date;

public interface NotificationsResponse {
    Long getId();

    String getTitle();

    Integer getType();

    String getSummary();

    String getUnread();

    String getImageUrl();

    String getRedirectUrl();

    @JsonFormatDate
    Date getCreateAt();
}
