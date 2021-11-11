package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Product;
import com.mybang.khweb.entity.Villa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface VillaRepository extends JpaRepository<Villa, Long> {

    @Query("select m from Villa m where m.villaNo = :villaNo")
    Optional<Villa> findByVilla(Long villaNo);

}
