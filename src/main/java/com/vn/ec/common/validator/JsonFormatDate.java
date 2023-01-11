package com.vn.ec.common.validator;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.vn.ec.utlis.DateTimeUtils.DATE_TIME_PATTERN;
import static com.vn.ec.utlis.DateTimeUtils.TIME_ZONE_VI;

@JacksonAnnotationsInside
@Retention(RetentionPolicy.RUNTIME)
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN, timezone = TIME_ZONE_VI)
public @interface JsonFormatDate {
}
