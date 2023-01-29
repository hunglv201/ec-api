package com.vn.ec.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RankingInfoResponse {
    private String name;
    private String imageUrl;
    private Integer discountPercent;
}
