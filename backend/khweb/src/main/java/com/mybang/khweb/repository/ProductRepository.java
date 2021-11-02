package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select m from Product m where m.productNo = :productNo")
    Optional<Product> findByProduct(Long productNo);

    //Optional<Product> findByEmail(String email);

    // 찜하기
    Optional<Product> findById(Long productNo);
}
