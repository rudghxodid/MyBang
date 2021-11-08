package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StationRepository extends JpaRepository<Station, Long> {
    List<Station> findByNameContaining(String name);
}
