package com.vn.ec.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBase {
    private Integer currentPage;
    private Integer perPage;
    private Long total;
    private Integer totalPages;

    private Object result;
}
