package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Gongzi;
import com.mybang.khweb.entity.Officetel;
import com.mybang.khweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GongziRepository extends JpaRepository<Gongzi, Long> {

    Optional<Gongzi> findByGongziNo(Long gongziNo);
}
