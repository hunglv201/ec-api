package com.vn.ec.repository;

import com.vn.ec.dto.response.ProductResponse;
import com.vn.ec.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {

    @Query(value = "SELECT p.id as id , p.name as name,\n" +
            "       p.description as description,\n" +
            "       p.price as price,\n" +
            "       i.image_url as imageUrl\n" +
            "            FROM products p\n" +
            "        LEFT JOIN images i on i.id= p.image_id\n" +
            "            WHERE p.available_flag =true\n" +
            "            AND p.delete_flag = false",nativeQuery = true)
    Page<ProductResponse> getProductData(Pageable pageable);

}
