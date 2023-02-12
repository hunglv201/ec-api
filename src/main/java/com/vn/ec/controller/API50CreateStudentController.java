package com.vn.ec.controller;

import com.vn.ec.dto.request.CreateStudentRequest;
import com.vn.ec.service.CreateStudentService;
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
public class API50CreateStudentController {
    private final CreateStudentService createStudentService;
    @PostMapping("/create-student")
    public ResponseEntity<?> login(@Valid @RequestBody CreateStudentRequest request) {
        return ResponseEntity.ok().body(createStudentService.createStudent(request));
    }
}
