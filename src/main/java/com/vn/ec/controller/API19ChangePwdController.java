package com.vn.ec.controller;

import com.vn.ec.common.CustomerAccountService;
import com.vn.ec.dto.ApiResponse;
import com.vn.ec.dto.request.API19ChangePwdRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class API19ChangePwdController {
    private final CustomerAccountService service;

    @PutMapping("/change-password")
    public ResponseEntity<ApiResponse> changePassword(@Valid @RequestBody API19ChangePwdRequest req) {
        return ResponseEntity.ok().body(service.changePassword(req));
    }
}
