package com.vn.ec.controller;

import com.vn.ec.common.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class Api30NotificationController {
    private final NotificationService notificationService;

//    @GetMapping("/notification")
//    public ResponseEntity<?> getNotification(@Valid NotificationRequest request) {
//        return ResponseEntity.ok().body(notificationService.getByUserId(request));
//    }
}
