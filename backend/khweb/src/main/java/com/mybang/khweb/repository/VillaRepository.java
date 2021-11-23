package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Villa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface VillaRepository extends JpaRepository<Villa, Long> {

    Optional<Villa> findByVillaNo(Long villaNo);

    List<Villa> findByAgentId(String agentId);
}
