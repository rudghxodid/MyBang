package com.mybang.khweb.repository;

import com.mybang.khweb.entity.memberRelated.LikedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LikedProductRepository extends JpaRepository<LikedProduct, Long> {

    List<LikedProduct> findByMemberNo(Long memberNo);

    @Transactional
    @Modifying
    @Query("delete LikedProduct la where la.noticeNo = :noticeNo and la.memberNo = :memberNo")
    void delete(Long noticeNo, Long memberNo);
}
