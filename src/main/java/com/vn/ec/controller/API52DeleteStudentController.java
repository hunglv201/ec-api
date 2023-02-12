package com.vn.ec.controller;

import com.vn.ec.service.DeleteStudentService;
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
public class API52DeleteStudentController {
    private final DeleteStudentService updateStudentService;
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteAccount(@NotNull @PathVariable Long id) {
        return ResponseEntity.ok().body(updateStudentService.deleteStudent(id));
    }
}
