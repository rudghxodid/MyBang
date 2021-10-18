package com.mybang.khweb.repository;

import com.mybang.khweb.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findById(String userId);
}
