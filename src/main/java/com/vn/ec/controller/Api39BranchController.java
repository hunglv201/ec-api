package com.vn.ec.controller;

import com.vn.ec.dto.ApiResponse;
import com.vn.ec.service.BranchesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class Api39BranchController {
    private final BranchesService branchesService;
    @GetMapping("/branch")
    public ResponseEntity<ApiResponse>
    getBranch() {
        return ResponseEntity.ok().body(branchesService.getAllBranch());
    }
    @GetMapping("/v2/branch")
    public ResponseEntity<ApiResponse>
    getBranchV2() {
        return ResponseEntity.ok().body(branchesService.getAllBranchV2());
    }
    @GetMapping("/v3/branch")
    public ResponseEntity<ApiResponse>
    getBranchV3() {
        return ResponseEntity.ok().body(branchesService.getAllBranchV3());
    }
}
