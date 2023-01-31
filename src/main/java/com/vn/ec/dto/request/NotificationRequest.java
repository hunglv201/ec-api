package com.vn.ec.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class NotificationRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Integer currentPage;
}
