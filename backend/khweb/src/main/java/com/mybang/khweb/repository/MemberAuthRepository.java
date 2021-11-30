package com.mybang.khweb.repository;

import com.mybang.khweb.entity.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {

    Optional<MemberAuth> findByMemberNo(Long memberNo);
}
