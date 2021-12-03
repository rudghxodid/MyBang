package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Gongzi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GongziRepository extends JpaRepository<Gongzi, Long> {

    Optional<Gongzi> findByGongziNo(Long gongziNo);
}
