package com.vn.ec.dto;

import com.vn.ec.common.Constants;
import com.vn.ec.common.validator.JsonFormatDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private ApiResponse.StatusResponse status;

    @JsonFormatDate
    private Date timestamp;

    private String errorMessage;

    private Map<String, String> details;

    public ErrorResponse(Integer code, Date timestamp, String message, Map<String, String> details) {
        this.status = new ApiResponse.StatusResponse(code, Constants.NONE_COMPLETE);
        this.timestamp = timestamp;
        this.errorMessage = message;
        this.details = details;
    }

    public ErrorResponse(Integer code, Date timestamp, String message) {
        this.status = new ApiResponse.StatusResponse(code, Constants.NONE_COMPLETE);
        this.timestamp = timestamp;
        this.errorMessage = message;
    }
}
