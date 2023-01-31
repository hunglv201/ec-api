package com.vn.ec.controller;

import com.vn.ec.service.CustomerAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class Api40DeleteAccountController {
    private final CustomerAccountService customerAccountService;
    @DeleteMapping("/account/{id}")
    public ResponseEntity<?> deleteAccount(@NotNull @PathVariable Long id) {
        return ResponseEntity.ok().body(customerAccountService.deleteAccount(id));
    }
    @DeleteMapping("/account/v2/{id}")
    public ResponseEntity<?> deleteAccountV2(@NotNull @PathVariable Long id) {
        return ResponseEntity.ok().body(customerAccountService.deleteAccountV2(id));
    }
}
