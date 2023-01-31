package com.vn.ec.controller;

import com.vn.ec.dto.request.SignUpRequest;
import com.vn.ec.service.SignUpService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class API3SignUpController {
    private final SignUpService signUpService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> login(@Valid @RequestBody SignUpRequest request) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        return ResponseEntity.ok().body(signUpService.signUp(request));
    }

}
