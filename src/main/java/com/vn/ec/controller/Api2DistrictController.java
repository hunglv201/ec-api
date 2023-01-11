package com.vn.ec.controller;

import com.vn.ec.dto.ApiResponse;
import com.vn.ec.service.Api02Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class Api2DistrictController {
    private final Api02Service api02Service;

    @GetMapping("/city/{id}")
    public ResponseEntity<ApiResponse> provinceCode(@NotNull @PathVariable String id) {
        return ResponseEntity.ok().body(api02Service.getDistrict(id));
    }
}
