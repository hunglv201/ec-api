package com.vn.ec.controller;

import com.vn.ec.dto.request.API51UpdatePwdRequest;
import com.vn.ec.service.UpdateStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class API51UpdateStudentController {
    private final UpdateStudentService updateStudentService;
    @PutMapping("/update-student/{id}")
    public ResponseEntity<?> changePassword(@Valid @RequestBody API51UpdatePwdRequest req, @PathVariable Long id) {
        return ResponseEntity.ok().body(updateStudentService.updateStudent(req, id));
    }


}
