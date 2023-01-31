package com.vn.ec.controller;

import com.vn.ec.common.CustomerAccountService;
import com.vn.ec.dto.request.API21ResetPwdRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class API21ResetPwdController {
    private final CustomerAccountService service;

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody API21ResetPwdRequest req) {
        return ResponseEntity.ok().body(service.resetPassword(req));
    }
}
