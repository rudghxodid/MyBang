package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Officetel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface OfficetelRepository extends JpaRepository<Officetel, Long> {

    Optional<Officetel> findByOfficetelNo(Long officetelNo);

    List<Officetel> findByAgentId(String agentId);

}
