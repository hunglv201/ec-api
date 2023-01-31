package com.vn.ec.controller;

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
    public ResponseEntity<?> provinceCode(@NotNull @PathVariable String id) {
        return ResponseEntity.ok().body(api02Service.getDistrict(id));
    }
    @GetMapping("/v2/city/{id}")
    public ResponseEntity<?> provinceCode2(@NotNull @PathVariable String id) {
        return ResponseEntity.ok().body(api02Service.getDistrictV2(id));
    }
    @GetMapping("/v3/city/{id}")
    public ResponseEntity<?> provinceCode3(@NotNull @PathVariable String id) {
        return ResponseEntity.ok().body(api02Service.getDistrictV3(id));
    }
}
