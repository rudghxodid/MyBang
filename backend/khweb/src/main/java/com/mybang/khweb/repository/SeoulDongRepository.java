package com.mybang.khweb.repository;

import com.mybang.khweb.entity.SeoulDong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeoulDongRepository extends JpaRepository<SeoulDong, Long> {
    List<SeoulDong> findByGu(String gu);
}
