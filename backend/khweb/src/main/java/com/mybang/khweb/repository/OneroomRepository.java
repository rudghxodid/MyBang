package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Oneroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OneroomRepository extends JpaRepository<Oneroom, Long> {

    Optional<Oneroom> findByOneroomNo(Long oneroomNo);

    List<Oneroom> findByAgentId(String agentId);

}
