package com.vn.ec.dto.response;

import com.vn.ec.common.validator.JsonFormatDate;


import java.util.Date;


public interface MyInformationResponse {
   String getFullName();
   String getProvinceCode();
   String getProvinceName();
   String getDistrictCode();
   String getDistrictName();
   String getDetailAddress();
    @JsonFormatDate
   Date getBirthDate();
   Integer getGender();
   Integer getPoint();
   String getInviteCode();

  String getRankName();
  String getRankImageUrl();
  Integer getRankDiscountPercent();
   
}
