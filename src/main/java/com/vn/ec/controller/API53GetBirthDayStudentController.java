package com.vn.ec.controller;

import com.vn.ec.service.DeleteStudentService;
import com.vn.ec.service.GetBirthDayStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class API53GetBirthDayStudentController {
    private final GetBirthDayStudentService getBirthDayStudentService;
    @GetMapping("/birth-day")
    public ResponseEntity<?> getBirthDayStudent() {
        return ResponseEntity.ok().body(getBirthDayStudentService.getBirthDayStudent());
    }
}
