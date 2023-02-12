package com.vn.ec.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class ProductRequest {
    @NotNull
    private Integer currentPage;
}
