package com.vn.ec.controller;

import com.vn.ec.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class Api1CityController {
    private final CityService cityService;
    @GetMapping("/city")
    public ResponseEntity<?> dropDownProvinceCode() {
        return ResponseEntity.ok().body(cityService.getCity());
    }
    @GetMapping("/v2/city")
    public ResponseEntity<?> dropDownProvinceCode1() {
        return ResponseEntity.ok().body(cityService.getCityV2());
    }
    @GetMapping("/v3/city")
    public ResponseEntity<?> dropDownProvinceCode2() {
        return ResponseEntity.ok().body(cityService.getCityV3());
    }
}
