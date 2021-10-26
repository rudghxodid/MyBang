package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //@Query("select m from Product m where m.id = :id")
    //Optional<Product> findByProduct(Long id);

    //Optional<Product> findByUserId(String userId);

    //Optional<Product> findByEmail(String email);
}
