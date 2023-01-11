package com.vn.ec.dto;

import com.vn.ec.common.Constants;
import com.vn.ec.common.validator.JsonFormatDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private StatusResponse status;
    private Object result;

    public ApiResponse(Integer code, Integer completed, Object result) {
        this.status = new StatusResponse(code, completed);
        this.result = result;
    }

    public ApiResponse(Integer code, Integer completed) {
        this.status = new StatusResponse(code, completed);
    }

    public static ApiResponse apiResponseCompleted() {
        return new ApiResponse(Constants.HTTP_CODE_200, Constants.COMPLETED);
    }

    public static ApiResponse apiResponseHttpNoneComplete(int statusCode) {
        return new ApiResponse(statusCode, Constants.NONE_COMPLETE);
    }

    public static ApiResponse apiResponseCompleted(Object result) {
        return new ApiResponse(Constants.HTTP_CODE_200, Constants.COMPLETED, result);
    }

    public static ApiResponse apiResponseInvalid() {
        return new ApiResponse(Constants.HTTP_CODE_400, Constants.NONE_COMPLETE);
    }

    public static ApiResponse apiResponseInvalid(String mess) {
        return new ApiResponse(Constants.HTTP_CODE_400, Constants.NONE_COMPLETE, mess);
    }

    public static ApiResponse apiResponseInvalid(String mess, Date date) {
        return new ApiResponse(Constants.HTTP_CODE_400, Constants.NONE_COMPLETE, new ErrorMessage(mess, date));
    }

    public static ApiResponse apiResponseNotFound() {
        return new ApiResponse(Constants.HTTP_CODE_404, Constants.NONE_COMPLETE);
    }

    public static ApiResponse apiResponseNotFound(String mess) {
        return new ApiResponse(Constants.HTTP_CODE_404, Constants.NONE_COMPLETE, mess);
    }

    @AllArgsConstructor
    @Getter
    static class ErrorMessage {
        private String errorMessage;
        @JsonFormatDate
        private Date pendingTime;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class StatusResponse {
        private Integer code;
        private Integer completed;
    }

}
