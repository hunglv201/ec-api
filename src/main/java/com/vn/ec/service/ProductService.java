package com.vn.ec.service;

import com.vn.ec.dto.request.ProductRequest;
import com.vn.ec.dto.response.PageBase;
import com.vn.ec.dto.response.ProductResponse;
import com.vn.ec.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository ProductRepository;
    public PageBase getListProduct(Integer currentPage ){
        Pageable pageable = PageRequest.of(currentPage,3);
        Page<ProductResponse> listProduct=ProductRepository.getProductData(pageable);

        PageBase pageBase1 = new PageBase();
        pageBase1.setCurrentPage(currentPage);
        pageBase1.setPerPage(3);
        pageBase1.setTotal(listProduct.getTotalElements());
        pageBase1.setTotalPages(listProduct.getTotalPages());
        pageBase1.setResult(listProduct.getContent());
        return pageBase1;
    }
}
