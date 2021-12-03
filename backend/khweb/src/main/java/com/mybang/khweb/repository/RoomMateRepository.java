package com.mybang.khweb.repository;

import com.mybang.khweb.entity.RoomMate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoomMateRepository extends JpaRepository<RoomMate, Long> {
//    List<RoomMate> findAllByOrderByIdDesc();

    List<RoomMate> findByWriterName(String writer);
}
