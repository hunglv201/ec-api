package com.vn.ec.controller;


import com.vn.ec.dto.request.ProductRequest;
import com.vn.ec.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("api/ec")
public class Api7ProductController {
    private final ProductService ProductService;
    @GetMapping("/product")
    public ResponseEntity<?> getProduct(@RequestParam Integer currentPage) {
        return ResponseEntity.ok().body(ProductService.getListProduct(currentPage));
    }
}
