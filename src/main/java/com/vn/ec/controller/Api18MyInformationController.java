package com.vn.ec.controller;

import com.vn.ec.common.MyInformationService;
import com.vn.ec.dto.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class Api18MyInformationController {
    private final MyInformationService myInformationService;
    @GetMapping("/my-information")
    public ResponseEntity<ApiResponse> login(@NotNull @RequestParam Long userId) {
        return ResponseEntity.ok().body(myInformationService.myInformation(userId));
    }

}
